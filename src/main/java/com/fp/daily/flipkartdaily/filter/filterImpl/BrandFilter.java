package com.fp.daily.flipkartdaily.filter.filterImpl;


import com.fp.daily.flipkartdaily.filter.Filter;

import com.fp.daily.flipkartdaily.model.*;
import java.util.*;


public class BrandFilter implements Filter {
    private List<String> brands = new ArrayList<>();

    public BrandFilter(String brands) {
        this.brands.add(brands);
    }

    public BrandFilter(List<String> brands) {
        this.brands.addAll(brands);
    }

    @Override
    public boolean matches(Item item) {
        return brands.contains(item.getBrand());
    }
}

