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
package pl.otwartapw.ldapauth.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import javax.ws.rs.core.Response;

/**
 * REST service definition for authentication against LDAP.
 *
 * @author Adam Kowalewski
 */
public interface LdapAuthApi {

  /**
   * Perform LDAP login.
   *
   * @param dto user credentials.
   * @return when successful response with status 200 and {@link UserDto} within response body,
   * otherwise standard HTTP status codes.
   */
  @POST
  @Path("/login")
  @Consumes({APPLICATION_JSON, APPLICATION_XML})
  @Produces({APPLICATION_JSON, APPLICATION_XML})
  Response login(@NotNull @Valid LoginDto dto);

  /**
   * Perform LDAP login with custom LDAP context.
   *
   * @param dto user credentials with LDAP context.
   * @return when successful response with status 200 and {@link UserDto} within response body,
   * otherwise standard HTTP status codes.
   */
  @POST
  @Path("/loginldap")
  @Consumes({APPLICATION_JSON, APPLICATION_XML})
  @Produces({APPLICATION_JSON, APPLICATION_XML})
  Response loginLdap(@NotNull @Valid LoginLdapDto dto);

  /**
   * Returns artifact version.
   *
   * @return artifact version.
   */
  @GET
  @Path("/version")
  @Produces({TEXT_PLAIN})
  VersionDto getVersion();

}
