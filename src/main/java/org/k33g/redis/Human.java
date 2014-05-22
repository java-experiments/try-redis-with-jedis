package org.k33g.redis;


import java.util.HashMap;

public class Human {
  public HashMap<String, Object> fields = new HashMap<>();
  public Object get(String fieldName) { return this.fields.get(fieldName); }
  public void set(String fieldName, Object value) { this.fields.put(fieldName, value); }
}
