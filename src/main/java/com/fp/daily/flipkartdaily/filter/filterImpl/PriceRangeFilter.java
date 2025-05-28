package com.fp.daily.flipkartdaily.filter.filterImpl;

import com.fp.daily.flipkartdaily.model.*;

import com.fp.daily.flipkartdaily.filter.Filter;

public class PriceRangeFilter implements Filter {
    private Integer fromPrice;
    private Integer toPrice;

    public PriceRangeFilter(Integer fromPrice, Integer toPrice) {
        this.fromPrice = fromPrice;
        this.toPrice = toPrice;
    }

    @Override
    public boolean matches(Item item) {
        boolean fromCheck = (fromPrice == null) || (item.getPrice() >= fromPrice);
        boolean toCheck = (toPrice == null) || (item.getPrice() <= toPrice);
        return fromCheck && toCheck;
    }
}

