package com.rsanchezg.inventory.business.model;

import com.rsanchezg.inventory.domain.entity.Item;
import com.rsanchezg.inventory.util.Utils;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

/**
 * @author raasanch
 */
public class ItemDto {

  private Long id;
  @NotNull
  private BigDecimal sellingPrice;
  @NotNull
  private Long stock;
  @NotNull
  private String name;
  private String description;
  private String base64Image;

  public ItemDto() {
  }

  public ItemDto(Long id, BigDecimal sellingPrice, Long stock, String name,
      String description, String base64Image) {
    this.id = id;
    this.sellingPrice = sellingPrice;
    this.stock = stock;
    this.name = name;
    this.description = description;
    this.base64Image = base64Image;
  }

  public ItemDto(Item item) {
    this.id = item.getId();
    this.sellingPrice = item.getSellingPrice();
    this.name = item.getName();
    this.stock = item.getStock();
    this.description = item.getDescription();
    this.base64Image = Utils.encodeImageBase64(item.getImage());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(BigDecimal sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public Long getStock() {
    return stock;
  }

  public void setStock(Long stock) {
    this.stock = stock;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getBase64Image() {
    return base64Image;
  }

  public void setBase64Image(String base64Image) {
    this.base64Image = base64Image;
  }
}
