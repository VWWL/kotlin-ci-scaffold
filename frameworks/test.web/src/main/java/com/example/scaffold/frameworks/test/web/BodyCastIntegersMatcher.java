package com.example.scaffold.frameworks.test.web;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BodyCastIntegersMatcher<T extends Number & Comparable<T>> extends BodyCastNumberMatcher<T> {
    @Override
    public void match(T value) {
        assertThat(ALLOW_CLASSES).contains(value.getClass());
        realMatch(value);
    }

    private static final List<Class<?>> ALLOW_CLASSES = List.of(Integer.class, Long.class);
}