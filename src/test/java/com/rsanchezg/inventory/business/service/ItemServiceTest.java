package com.rsanchezg.inventory.business.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import com.rsanchezg.inventory.business.model.ItemDto;
import com.rsanchezg.inventory.domain.entity.Item;
import com.rsanchezg.inventory.domain.repository.ItemRepository;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author raasanch
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class ItemServiceTest {

  @Mock
  private ItemRepository itemRepository;

  @Autowired
  private ItemService itemService;

  private Item mockItem;

  @Before
  public void setup() {
    mockItem = new Item(new BigDecimal("16.50"), "", null);
    given(this.itemRepository.save(mockItem)).willReturn(mockItem);
  }


  @Test
  public void createItem() {
    ItemDto itemCreated = itemService.addItem(new ItemDto(mockItem));
    assertEquals(mockItem.getSellingPrice(), itemCreated.getSellingPrice());
    assertEquals(mockItem.getDescription(), itemCreated.getDescription());
    assertEquals(mockItem.getImage(), itemCreated.getBase64Image());
  }
}