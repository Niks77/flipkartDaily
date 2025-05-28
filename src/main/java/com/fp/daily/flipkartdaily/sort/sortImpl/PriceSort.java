package com.fp.daily.flipkartdaily.sort.sortImpl;

import com.fp.daily.flipkartdaily.sort.ItemSort;

import com.fp.daily.flipkartdaily.model.Item;

public class PriceSort implements ItemSort {
    private final boolean ascending;

    public PriceSort(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Item a, Item b) {
        return apply(a, b);
    }

    @Override
    public int apply(Item a, Item b) {
        return ascending ? Integer.compare(a.getPrice(), b.getPrice())
                         : Integer.compare(b.getPrice(), a.getPrice());
    }

    @Override
    public boolean isAscending() {
        return ascending;
    }
}