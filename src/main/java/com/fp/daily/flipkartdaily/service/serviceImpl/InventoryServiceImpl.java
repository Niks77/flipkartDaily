package com.fp.daily.flipkartdaily.service.serviceImpl;

import com.fp.daily.flipkartdaily.repository.*;
import com.fp.daily.flipkartdaily.filter.*;
import com.fp.daily.flipkartdaily.filter.filterImpl.*;

import com.fp.daily.flipkartdaily.sort.*;
import com.fp.daily.flipkartdaily.model.*;
import com.fp.daily.flipkartdaily.service.*;
import com.fp.daily.flipkartdaily.sort.*;
import com.fp.daily.flipkartdaily.sort.sortImpl.*;
import java.util.*;
import java.util.stream.Collectors;

public class InventoryServiceImpl implements InventoryService{
    private final InventoryRepository repository;

    public InventoryServiceImpl(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addItem(String brand, String category, int price) {
        if(price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        Item item = repository.findByBrandAndCategory(brand, category)
                .orElse(new Item(brand, category, price, 1));
        item.setPrice(price); 
        repository.save(item);
    }

    @Override
    public void addInventory(String brand, String category, int quantity) {
         if(quantity < 0){
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        Optional<Item> optionalItem = repository.findByBrandAndCategory(brand, category);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.addQuantity(quantity);
            repository.save(item);
        } else {
            System.out.println("Item not found: " + brand + ", " + category);
        }
    }
    @Override
    public List<Item> searchItems(List<Filter> filters, Comparator<Item> comparator) {
        if (comparator == null) {
            comparator = new QuantitySort(true);
        }
        return repository.findAll().stream()
                .filter(item -> filters.stream().allMatch(filter -> filter.matches(item)))
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> searchItems(List<Filter> filters) {
        return searchItems(filters, null);
    }
    @Override
    public void printInventory() {
        System.out.println("\nInventory :");
        Map<String, Map<String, Integer>> result = new TreeMap<>();
        for (Item item : repository.findAll()) {
            result.putIfAbsent(item.getBrand(), new TreeMap<>());
            result.get(item.getBrand()).put(item.getCategory(), item.getQuantity());
        }
        for (String brand : result.keySet()) {
            for (String category : result.get(brand).keySet()) {
                System.out.println(brand + " -> " + category + " -> " + result.get(brand).get(category));
            }
        }
    }
}



