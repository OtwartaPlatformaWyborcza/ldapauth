package pl.otwartapw.opw.ldapauth;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import pl.otwartapw.ldapauth.api.LdapAuthApi;
import pl.otwartapw.ldapauth.api.LoginDto;
import pl.otwartapw.ldapauth.api.LoginLdapDto;
import pl.otwartapw.ldapauth.api.VersionDto;

/**
 *
 * @author Adam Kowalewski
 */
@Path("/")
public class LdapAuthResource implements LdapAuthApi {

  @Override
  public Response login(LoginDto dto) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Response loginLdap(LoginLdapDto dto) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public VersionDto getVersion() {
    return VersionBuilder.build();
  }

}
