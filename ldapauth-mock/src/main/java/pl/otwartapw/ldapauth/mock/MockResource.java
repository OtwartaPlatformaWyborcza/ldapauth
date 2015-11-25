/*
 * The MIT License
 *
 * Copyright 2015 Adam Kowalewski.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package pl.otwartapw.ldapauth.mock;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.ldapauth.api.LdapAuthApi;
import pl.otwartapw.ldapauth.api.LdapConfigDto;
import pl.otwartapw.ldapauth.api.LoginDto;
import pl.otwartapw.ldapauth.api.LoginLdapDto;
import pl.otwartapw.ldapauth.api.UserDto;

/**
 * REST resource.
 *
 * @author Adam Kowalewski
 * @version 2015.10.03
 */
@Path("/")
public class MockResource implements LdapAuthApi {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Inject
  UserCache userCache;

  @Override
  public Response login(LoginDto dto) {
    logger.info("login");
    logger.trace("login {}", dto.toString());

    UserDto user = userCache.getUserMap().get(dto.getLogin());

    if (user == null) {
      logger.info("Login failed {}", dto.getLogin());
      return Response.status(Response.Status.FORBIDDEN).build();
    }
    logger.info("Login {}", dto.getLogin());
    return Response.ok().entity(user).build();
  }

  @Override
  public Response loginLdap(LoginLdapDto dto) {
    logger.info("loginLdap");
    logger.trace("loginLdap {}", dto.toString());

    LoginDto loginDto = dto.getLoginDto();
    LdapConfigDto configDto = dto.getConfigDto();

    logger.info("LDAP context {}", configDto.toString());
    return login(loginDto);
  }

  @PUT
  @Path("/user/{login}")
  @Consumes({APPLICATION_JSON, APPLICATION_XML})
  @Produces({APPLICATION_JSON, APPLICATION_XML})
  public Response addUser(@PathParam("login") @NotNull String login, @NotNull @Valid UserDto dto) {
    logger.info("addUser");
    logger.trace("addUser {}", dto.toString());

    userCache.addUser(dto);
    return Response.ok().build();
  }

  @Override
  public Response getVersion() {
    Version version = new Version();
    return Response.ok().entity(version.getVersionFull()).build();
  }

}
