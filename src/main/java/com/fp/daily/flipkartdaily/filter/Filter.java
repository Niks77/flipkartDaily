package com.fp.daily.flipkartdaily.filter;

import com.fp.daily.flipkartdaily.model.Item;
public interface Filter {
    boolean matches(Item item);
}
