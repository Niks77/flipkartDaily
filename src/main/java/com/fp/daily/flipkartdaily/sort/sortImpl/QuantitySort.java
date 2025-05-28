package com.fp.daily.flipkartdaily.sort.sortImpl;

import com.fp.daily.flipkartdaily.sort.ItemSort;
import com.fp.daily.flipkartdaily.model.*;

public class QuantitySort implements ItemSort {
    private final boolean ascending;

    public QuantitySort(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Item a, Item b) {
        return apply(a, b);
    }

    @Override
    public int apply(Item a, Item b) {
        return ascending ? Integer.compare(a.getQuantity(), b.getQuantity())
                         : Integer.compare(b.getQuantity(), a.getQuantity());
    }

    @Override
    public boolean isAscending() {
        return ascending;
    }
}