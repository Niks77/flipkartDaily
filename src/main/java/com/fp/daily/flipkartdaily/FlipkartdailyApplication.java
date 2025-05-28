package com.fp.daily.flipkartdaily;

import com.fp.daily.flipkartdaily.service.serviceImpl.*;
import com.fp.daily.flipkartdaily.sort.sortImpl.*;
import com.fp.daily.flipkartdaily.repository.InventoryRepository;
import com.fp.daily.flipkartdaily.repository.repositoryImpl.InMemoryInventoryRepository;
import com.fp.daily.flipkartdaily.service.*;
import com.fp.daily.flipkartdaily.filter.*;
import com.fp.daily.flipkartdaily.filter.filterImpl.*;
import com.fp.daily.flipkartdaily.model.*;
import java.util.*;
public class FlipkartdailyApplication {

	public static void main(String[] args) {

		InventoryRepository repository = new InMemoryInventoryRepository();
		InventoryService service = new InventoryServiceImpl(repository);

        // Add Items

        try{
            service.addItem("Amul", "Milk", 100);
            service.addItem("Amul", "Curd", 50);
            service.addItem("Nestle", "Milk", 60);
            service.addItem("Nestle", "Curd", 90);
            // service.addItem("Nestle", "Curd", 90);
            

            // Add Inventory
            service.addInventory("Amul", "Milk", 10);
            service.addInventory("Amul", "Milk", 20);

            service.addInventory("Nestle", "Milk", 5);
            service.addInventory("Nestle", "Curd", 10);
            service.addInventory("Amul", "Milk", 10);
            service.addInventory("Amul", "Curd", 5);
            // service.addInventory("Amul", "Curd", -5);

            System.out.println("Filters with default comparator");
            List<Filter> filters = List.of(new CategoryFilter("Milk"));
            List<Item> resultsDefaultSort = service.searchItems(filters);
            resultsDefaultSort.forEach(System.out::println);

            System.out.println("Filters with custom comparator");
            Comparator<Item> quantityDesc = new QuantitySort(false);
            List<Item> resultsCustomSort = service.searchItems(filters, quantityDesc);
            resultsCustomSort.forEach(System.out::println);

            System.out.println("No Filters with default comparator");
            List<Item> allItemsSortedByPrice = service.searchItems(Collections.emptyList());
            allItemsSortedByPrice.forEach(System.out::println);
            // Print Inventory Summary
            service.printInventory();
        } catch(IllegalArgumentException e){
            System.err.println(e);
        } catch(Exception e){
            System.err.println(e);
        }
	}

}
