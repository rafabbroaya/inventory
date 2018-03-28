package com.rsanchezg.inventory.web;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raasanch
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ItemController {

  @RequestMapping("/items")
  public Map<String, Object> getItems() {
    Map<String, Object> items = new HashMap<>();
    items.put("id", UUID.randomUUID());
    items.put("content", "Hello World");
    return items;
  }
}
