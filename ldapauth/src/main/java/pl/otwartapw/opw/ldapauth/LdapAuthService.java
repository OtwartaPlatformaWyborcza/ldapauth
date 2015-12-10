/*
 * The MIT License
 *
 * Copyright 2015 Otwarta Platforma Wyborcza.
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
package pl.otwartapw.opw.ldapauth;

import java.io.Serializable;
import java.util.Hashtable;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.ldapauth.api.LoginDto;
import pl.otwartapw.ldapauth.api.UserDto;

/**
 *
 * @author Adam Kowalewski
 */
@Stateless
public class LdapAuthService implements Serializable {

  private static final long serialVersionUID = 1L;
  private static final Logger logger = LoggerFactory.getLogger(LdapAuthService.class);

  private LdapContext ldapCtx;
  private String ldapUrl;
  private String ldapAuthentication;

  public LdapAuthService() {
  }

  public UserDto login(LoginDto login) {
    return null;
  }

  LdapContext bindLdap(String url, String authentication, String login, String password)
          throws NamingException {

    Hashtable<String, String> cfg = new Hashtable<>();
    cfg.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    cfg.put(Context.PROVIDER_URL, url);
    cfg.put(Context.SECURITY_AUTHENTICATION, authentication);
    cfg.put(Context.SECURITY_PRINCIPAL, login);
    cfg.put(Context.SECURITY_CREDENTIALS, password);
    cfg.put("java.naming.ldap.attributes.binary", "objectGUID");

    try {
      return new InitialLdapContext(cfg, null);
    } catch (NamingException ne) {
      throw new NamingException("LDAP bind failed" + ne.getExplanation());
    }
  }

}
