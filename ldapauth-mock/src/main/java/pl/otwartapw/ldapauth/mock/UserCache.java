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
import java.util.HashMap;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.otwartapw.ldapauth.api.UserDto;

/**
 * Simple cache implementation with fixed size.
 *
 * @author Adam Kowalewski
 * @version 2015.10.15
 */
@ApplicationScoped
public class UserCache implements Serializable {

  private static final long serialVersionUID = 1L;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Resource(lookup = "java:global/ldapauth-mock/usercache")
  private int cacheSize;

  private HashMap<String, UserDto> userMap;

  public UserCache() {
    userMap = new HashMap<>();
  }

  public UserCache(HashMap<String, UserDto> userMap, int cacheSize) {
    this.userMap = userMap;
    this.cacheSize = cacheSize;
  }

  /**
   * Adds given dataset to cache. Cache size check is implemented and will if required clear all
   * previous entries from cache.
   *
   * @param user complete dataset for user.
   * @author Adam Kowalewski
   * @version 2016.01.20
   */
  public void addUser(UserDto user) {
    logger.trace("addUser {}", user);
    if (userMap.size() >= cacheSize) {
      logger.info("Cache cleanup");
      userMap.clear();
    }
    userMap.put(user.getsAMAccountName(), user);
    logger.trace("Cache status {}/{}", userMap.size(), cacheSize);
  }

  public HashMap<String, UserDto> getUserMap() {
    return userMap;
  }

  public void setUserMap(HashMap<String, UserDto> userList) {
    this.userMap = userList;
  }

}
