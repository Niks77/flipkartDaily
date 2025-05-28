package com.fp.daily.flipkartdaily.filter.filterImpl;

import com.fp.daily.flipkartdaily.filter.Filter;
import com.fp.daily.flipkartdaily.model.*;
import java.util.*;
public class CategoryFilter implements Filter {
    private List<String> categories = new ArrayList<>();

    public CategoryFilter(List<String> categories) {
        this.categories.addAll(categories);
    }

    public CategoryFilter(String category) {
        this.categories.add(category);
    }

    @Override
    public boolean matches(Item item) {
        return categories.contains(item.getCategory());
    }
}
