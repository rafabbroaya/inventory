package com.rsanchezg.inventory.business.service;

import com.rsanchezg.inventory.business.model.ItemDto;
import com.rsanchezg.inventory.domain.entity.Item;
import com.rsanchezg.inventory.domain.repository.ItemRepository;
import java.util.ArrayList;
import java.util.Base64;
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
      ItemDto itemDto = parseItemDto(item);
      itemsDto.add(itemDto);
    }
    return new PageImpl<ItemDto>(itemsDto, pageable, items.getTotalPages());
  }

  private ItemDto parseItemDto(Item item) {
    return new ItemDto(item.getId(), item.getSellingPrice(), item.getDescription(),
        encodeImageBase64(item.getImage()));
  }

  private String encodeImageBase64(byte[] image) {
    if (image != null) {
      byte[] encode = Base64.getEncoder().encode(image);
      return new String(encode);
    }
    return null;
  }
}
