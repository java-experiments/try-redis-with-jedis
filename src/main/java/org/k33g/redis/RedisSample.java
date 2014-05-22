package org.k33g.redis;


import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Objects;

public class RedisSample {

  public static void main(String[] list) {

    Jedis jedis = new Jedis("localhost", 6379);

    HashMap<String, String> bob = new HashMap<String, String>() {{
      put("firstName", "Bob");
      put("lastName", "Morane");
    }};

    HashMap<String, String> john = new HashMap<String, String>() {{
      put("firstName", "John");
      put("lastName", "Doe");
    }};

    HashMap<String, String> jane = new HashMap<String, String>() {{
      put("firstName", "Jane");
      put("lastName", "Doe");
    }};

    /* === save all to server === */

    jedis.hmset("bob:male", bob);
    jedis.hmset("john:male", john);
    jedis.hmset("jane:female", jane);

    /* === get Jane === */

    System.out.println(jedis.hgetAll("jane:female"));
    //{lastName=Doe, firstName=Jane}

    /* === get All Humans keys === */

    jedis.keys("*").forEach((key)->System.out.println(key));
    /*
    bob:male
    john:male
    jane:female
     */

    /* === get All Humans === */

    jedis.keys("*").forEach((key)->System.out.println(jedis.hgetAll(key)));
    /*
    {firstName=Bob, lastName=Morane}
    {firstName=John, lastName=Doe}
    {lastName=Doe, firstName=Jane}
     */

    /* === get only males === */
    jedis.keys("*:male").forEach((key)->System.out.println(jedis.hgetAll(key)));
    /*
    {firstName=Bob, lastName=Morane}
    {firstName=John, lastName=Doe}
     */
  }


}
