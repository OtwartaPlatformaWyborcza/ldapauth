/*
 * The MIT License
 *
 * Copyright 2016 Otwarta Platforma Wyborcza.
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

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.otwartapw.ldapauth.api.UserDto;

/**
 *
 * @author Adam Kowalewski
 */
public class UserCacheTest {

  private UserCache sut;
  private UserDto bolek;
  private UserDto lolek;

  public UserCacheTest() {
  }

  @Before
  public void setUp() {
    bolek = PersonBuilder.bolek();
    lolek = PersonBuilder.lolek();
    HashMap<String, UserDto> userMap = new HashMap<>();
    sut = new UserCache(userMap, 2);
  }

  /**
   * Test of addUser method, of class UserCache.
   */
  @Test
  public void testAddUser() {
    System.out.println("addUser");
    sut.addUser(lolek);
    assertTrue(sut.getUserMap().size() == 1);
  }

  @Test
  public void testCache() {
    System.out.println("testCache: verify working cache size limit");
    sut.addUser(lolek);
    sut.addUser(bolek);
    assertTrue(sut.getUserMap().size() == 2);
  }

}
