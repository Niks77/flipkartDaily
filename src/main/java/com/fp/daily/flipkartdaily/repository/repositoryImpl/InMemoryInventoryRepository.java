package com.fp.daily.flipkartdaily.repository.repositoryImpl;


import com.fp.daily.flipkartdaily.filter.Filter;

import com.fp.daily.flipkartdaily.model.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.fp.daily.flipkartdaily.repository.InventoryRepository;
public class InMemoryInventoryRepository implements InventoryRepository {
    private final Map<String, Item> inventory = new ConcurrentHashMap<>();

    private String generateKey(String brand, String category) {
        return brand.toLowerCase() + "#" + category.toLowerCase();
    }

    @Override
    public void save(Item item) {
        String key = generateKey(item.getBrand(), item.getCategory());
        inventory.put(key, item);
    }

    @Override
    public Optional<Item> findByBrandAndCategory(String brand, String category) {
        String key = generateKey(brand, category);
        return Optional.ofNullable(inventory.get(key));
    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(inventory.values());
    }
}
