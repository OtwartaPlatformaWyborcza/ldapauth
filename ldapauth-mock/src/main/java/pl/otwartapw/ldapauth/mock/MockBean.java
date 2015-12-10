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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.otwartapw.ldapauth.api.UserDto;

/**
 *
 * @author Adam Kowalewski
 */
@Named
@ViewScoped
public class MockBean implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  UserCache userCache;

  public MockBean() {
  }

  /**
   * Generates default user list.
   *
   * @author Adam Kowalewski
   * @version 2015.12.03
   */
  public void populate() {
    List<String> userList = new ArrayList<>();
    userList.add("teama");
    userList.add("teamb");
    userList.add("teamc");

    userCache.addUser(new UserDto("adam", "Adam", "Kowalewski", generateGuid(), "adam@localhost", userList, userList));
    userCache.addUser(new UserDto("tom", "Tom", "Kowalewski", generateGuid(), "tom@localhost", userList, userList));
    userCache.addUser(new UserDto("max", "Max", "Kowalewski", generateGuid(), "max@localhost", userList, userList));

    List<String> adminList = new ArrayList<>();
    adminList.add("admin");
    userCache.addUser(new UserDto("admin", "admin", "", generateGuid(), "admin@localhost", adminList, adminList));
    userCache.addUser(new UserDto("administrator", "Administrator", "", generateGuid(), "administrator@localhost", adminList, adminList));

  }

  public void clear() {
    userCache.getUserMap().clear();
  }

  public List<UserDto> getUserList() {
    List<UserDto> userList = new ArrayList<>();

    for (Map.Entry<String, UserDto> entry : userCache.getUserMap().entrySet()) {
      userList.add(entry.getValue());
    }
    return userList;
  }

  public String getVersion() {
    return VersionBuilder.build().toString();
  }

  String generateGuid() {
    return "11112222333344445555666677778888";
  }

}
