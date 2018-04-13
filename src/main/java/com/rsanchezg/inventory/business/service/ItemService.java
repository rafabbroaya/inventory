package com.rsanchezg.inventory.business.service;

import com.rsanchezg.inventory.domain.entity.Item;
import com.rsanchezg.inventory.domain.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author raasanch
 */
@Service
public class ItemService {

  @Autowired
  ItemRepository itemRepository;

  public Iterable<Item> getItems(Pageable pageable) {
    return itemRepository.findAll(pageable);
  }
}
