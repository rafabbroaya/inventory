package com.rsanchezg.inventory.domain.entity;

import com.rsanchezg.inventory.business.model.ItemDto;
import com.rsanchezg.inventory.util.Utils;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author raasanch
 */
@Entity
public class Item {

  @Id
  @GeneratedValue
  private Long id;
  @NotNull
  private BigDecimal sellingPrice;
  @NotNull
  private String description;
  private byte[] image;

  public Item() {
  }

  public Item(BigDecimal sellingPrice, String description, byte[] image) {
    this.sellingPrice = sellingPrice;
    this.description = description;
    this.image = image;
  }

  public Item(ItemDto itemDto) {
    this.sellingPrice = itemDto.getSellingPrice();
    this.description = itemDto.getDescription();
    this.image = Utils.decodeImageBase64(itemDto.getBase64Image());
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

  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }
}
