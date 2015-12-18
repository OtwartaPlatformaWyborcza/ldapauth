package pl.otwartapw.opw.ldapauth;

import javax.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.ldapauth.api.LdapAuthApi;
import pl.otwartapw.ldapauth.api.LoginDto;
import pl.otwartapw.ldapauth.api.LoginLdapDto;
import pl.otwartapw.ldapauth.api.UserDto;
import pl.otwartapw.ldapauth.api.VersionDto;

/**
 *
 * @author Adam Kowalewski
 */
@Path("/")
public class LdapAuthResource implements LdapAuthApi {

  private static final Logger logger = LoggerFactory.getLogger(LdapAuthResource.class);

  @Override
  public UserDto login(LoginDto dto) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public UserDto loginLdap(LoginLdapDto dto) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public VersionDto getVersion() {
    logger.info("getVersion()");
    String uri = "/META-INF/maven/pl.otwartapw.ldapauth/ldapauth/pom.properties";
    return VersionBuilder.build(uri);
  }

}
