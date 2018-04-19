package com.rsanchezg.inventory.business.model;

import java.math.BigDecimal;

/**
 * @author raasanch
 */
public class ItemDto {
  private Long id;
  private BigDecimal sellingPrice;
  private String description;
  private String base64Image;

  public ItemDto(Long id, BigDecimal sellingPrice, String description, String base64Image) {
    this.id = id;
    this.sellingPrice = sellingPrice;
    this.description = description;
    this.base64Image = base64Image;
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
