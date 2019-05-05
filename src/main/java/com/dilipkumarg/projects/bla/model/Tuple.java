package com.dilipkumarg.projects.bla.model;

import java.util.Objects;

public class Tuple<K, V> {

    private final K key;
    private final V value;

    public Tuple(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }

    @Override
    public boolean equals(final Object o) {

        if (this == o) return true;
        if (!(o instanceof Tuple)) return false;
        final Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return Objects.equals(getKey(), tuple.getKey()) &&
                Objects.equals(getValue(), tuple.getValue());
    }
}
