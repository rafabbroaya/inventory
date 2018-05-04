package com.rsanchezg.inventory.web;

import com.rsanchezg.inventory.business.model.ItemDto;
import com.rsanchezg.inventory.business.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raasanch
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token",
    "content-type"})
public class ItemController {

  @Autowired
  ItemService itemService;

  @GetMapping("/items")
  public Page<ItemDto> getItems(Pageable pageable) {
    return itemService.getItems(pageable);
  }

  @GetMapping("/items/{id}")
  public ItemDto getItem(@PathVariable Long id) {
    return itemService.getItem(id);
  }

  @PostMapping("/items")
  @ResponseStatus(HttpStatus.CREATED)
  public ItemDto addItem(@RequestBody @Validated ItemDto item) {
    return itemService.addItem(item);
  }

}
