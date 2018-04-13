package com.rsanchezg.inventory.web;

import com.rsanchezg.inventory.business.service.ItemService;
import com.rsanchezg.inventory.domain.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raasanch
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token"})
public class ItemController {

  @Autowired
  ItemService itemService;

  @RequestMapping("/items")
  public Iterable<Item> getItems(Pageable pageable) {
    return itemService.getItems(pageable);
  }
}
