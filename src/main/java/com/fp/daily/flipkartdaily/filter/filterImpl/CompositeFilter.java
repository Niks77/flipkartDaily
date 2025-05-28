package com.fp.daily.flipkartdaily.filter.filterImpl;

import com.fp.daily.flipkartdaily.model.*;

import com.fp.daily.flipkartdaily.filter.Filter;

import java.util.*;

public class CompositeFilter implements Filter {
    private List<Filter> filters = new ArrayList<>();

    public CompositeFilter(List<Filter> filters) {
        this.filters.addAll(filters);
    }
    public CompositeFilter(Filter filter) {
        this.filters.add(filter);
    }

    @Override
    public boolean matches(Item item) {
        for (Filter filter : filters) {
            if (!filter.matches(item)) return false;
        }
        return true;
    }
}

