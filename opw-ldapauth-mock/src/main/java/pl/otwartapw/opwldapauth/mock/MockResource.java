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
package pl.otwartapw.opwldapauth.mock;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import pl.otwartapw.opw.ldapauth.model.LdapAuthApi;
import pl.otwartapw.opw.ldapauth.model.LoginDto;
import pl.otwartapw.opw.ldapauth.model.LoginLdapDto;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import pl.otwartapw.opw.ldapauth.model.UserDto;

/**
 *
 * @author Adam Kowalewski
 */
@Path("/")
public class MockResource implements LdapAuthApi {

    @Inject
    UserCache userCache;

    @Override
    public Response login(LoginDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response loginLdap(LoginLdapDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @PUT
    @Path("/user/{login}")
    @Consumes({APPLICATION_JSON, APPLICATION_XML})
    @Produces({APPLICATION_JSON, APPLICATION_XML})
    public Response addUser(@PathParam("login") @NotNull String login, @NotNull @Valid UserDto dto) {
        userCache.addUser(dto);
        return Response.ok().build();
    }

    @Override
    public Response getVersion() {
        Version version = new Version();
        return Response.ok().entity(version.getVersionFull()).build();
    }

}