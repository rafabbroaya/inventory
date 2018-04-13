package com.rsanchezg.inventory.domain.repository;

import com.rsanchezg.inventory.domain.entity.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author raasanch
 */
@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

}
