package com.fp.daily.flipkartdaily.service;

import com.fp.daily.flipkartdaily.repository.*;
import com.fp.daily.flipkartdaily.filter.*;
import com.fp.daily.flipkartdaily.sort.*;
import com.fp.daily.flipkartdaily.model.*;


import java.util.*;
import java.util.stream.Collectors;

public interface InventoryService {

    public void addItem(String brand, String category, int price);

    public void addInventory(String brand, String category, int quantity);

    public List<Item> searchItems(List<Filter> filters, Comparator<Item> comparator);

    public List<Item> searchItems(List<Filter> filters);
  
    public void printInventory();
}

