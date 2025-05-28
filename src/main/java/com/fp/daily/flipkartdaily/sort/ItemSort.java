package com.fp.daily.flipkartdaily.sort;
import com.fp.daily.flipkartdaily.model.Item;
import java.util.Comparator;
public interface ItemSort extends Comparator<Item> {
    int apply(Item a, Item b); 
    public boolean isAscending();
}