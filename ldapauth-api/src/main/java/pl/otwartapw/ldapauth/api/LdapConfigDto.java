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

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO represents LDAP configuration. 
 *
 * @author Adam Kowalewski <adamkowalewski.com>
 * @version 2016.01.14
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LdapConfigDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String providerUrl;
  private String securityAuthentication;
  private String searchRoot;
  private String searchFilter;

  public LdapConfigDto() {
  }

  public LdapConfigDto(String providerUrl, String securityAuthentication, String searchRoot, String searchFilter) {
    this.providerUrl = providerUrl;
    this.securityAuthentication = securityAuthentication;
    this.searchRoot = searchRoot;
    this.searchFilter = searchFilter;
  }

  public String getProviderUrl() {
    return providerUrl;
  }

  public void setProviderUrl(String providerUrl) {
    this.providerUrl = providerUrl;
  }

  public String getSecurityAuthentication() {
    return securityAuthentication;
  }

  public void setSecurityAuthentication(String securityAuthentication) {
    this.securityAuthentication = securityAuthentication;
  }

  public String getSearchRoot() {
    return searchRoot;
  }

  public void setSearchRoot(String searchRoot) {
    this.searchRoot = searchRoot;
  }

  public String getSearchFilter() {
    return searchFilter;
  }

  public void setSearchFilter(String searchFilter) {
    this.searchFilter = searchFilter;
  }

  @Override
  public String toString() {
    return "LdapConfigDto{" + "providerUrl=" + providerUrl + ", securityAuthentication=" + securityAuthentication + ", searchRoot=" + searchRoot + ", searchFilter=" + searchFilter + '}';
  }

}
