package com.developerprince.yuppie.chef.review.service.services;

import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class BaseResources {
    public static<T> Iterable<T> iteratorToIterable(Iterator<T> iterator)
    {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return iterator;
            }
        };
    }
}
