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

import java.io.IOException;
import javax.annotation.Resource;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.ldapauth.api.LdapAuthHeaders;

/**
 * Filter applied to every request before processing.
 *
 * @author Adam Kowalewski
 * @version 2015.10.03
 */
@Provider
public class RequestFilter implements ContainerRequestFilter {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Resource(lookup = "java:global/opw/ldapauth-mock/secretkey")
  private String secretkey;

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    String requestToken = requestContext.getHeaderString(LdapAuthHeaders.OPW_HEADER_LDAPAUTH_TOKEN);

    if (requestToken == null || !requestToken.equals(secretkey)) {
      logger.warn("Bad request token {}", requestToken);
      Response response = Response
              .status(Response.Status.FORBIDDEN)
              .entity("Bad request token.")
              .build();

      throw new ForbiddenException(response);
    }

  }

}
