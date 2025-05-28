package com.fp.daily.flipkartdaily.repository;
import com.fp.daily.flipkartdaily.model.Item;
import java.util.List;
import java.util.Optional;
public interface InventoryRepository {
    void save(Item item);
    Optional<Item> findByBrandAndCategory(String brand, String category);
    List<Item> findAll();
}