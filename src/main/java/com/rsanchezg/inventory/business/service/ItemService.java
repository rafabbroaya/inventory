package com.rsanchezg.inventory.business.service;

import com.rsanchezg.inventory.business.model.ItemDto;
import com.rsanchezg.inventory.domain.entity.Item;
import com.rsanchezg.inventory.domain.repository.ItemRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author raasanch
 */
@Service
public class ItemService {

  @Autowired
  ItemRepository itemRepository;

  public Page<ItemDto> getItems(Pageable pageable) {
    Page<Item> items = itemRepository.findAll(pageable);
    List<ItemDto> itemsDto = new ArrayList<>();

    for (Item item : items
        ) {
      ItemDto itemDto = new ItemDto(item);
      itemsDto.add(itemDto);
    }
    return new PageImpl<>(itemsDto, pageable, items.getTotalPages());
  }

  public ItemDto addItem(ItemDto itemDto) {
    Item item = itemRepository.save(new Item(itemDto));
    return new ItemDto(item);
  }

  public ItemDto getItem(Long id) {
    return new ItemDto(itemRepository.findOne(id));
  }

}
