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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adam Kowalewski
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String sAMAccountName;
  private String firstname;
  private String lastname;
  private String guid;
  private String email;
  private List<String> groupList;
  private List<String> groupCanonicalList;

  public UserDto() {
    groupList = new ArrayList<>();
    groupCanonicalList = new ArrayList<>();
  }

  public UserDto(String sAMAccountName, String firstname, String lastname, String guid, String email,
          List<String> groupList, List<String> groupCanonicalList) {
    this.sAMAccountName = sAMAccountName;
    this.firstname = firstname;
    this.lastname = lastname;
    this.guid = guid;
    this.email = email;
    this.groupList = groupList;
    this.groupCanonicalList = groupCanonicalList;
  }

  public String getsAMAccountName() {
    return sAMAccountName;
  }

  public void setsAMAccountName(String sAMAccountName) {
    this.sAMAccountName = sAMAccountName;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getGroupList() {
    return groupList;
  }

  public void setGroupList(List<String> groupList) {
    this.groupList = groupList;
  }

  public List<String> getGroupCanonicalList() {
    return groupCanonicalList;
  }

  public void setGroupCanonicalList(List<String> groupCanonicalList) {
    this.groupCanonicalList = groupCanonicalList;
  }

  @Override
  public String toString() {
    return "UserDto{"
            + "sAMAccountName=" + sAMAccountName
            + ", firstname=" + firstname
            + ", lastname=" + lastname
            + ", guid=" + guid
            + ", email=" + email
            + ", groupList=" + groupList.size()
            + ", groupCanonicalList=" + groupCanonicalList.size()
            + '}';
  }

}
