package model;

import java.io.Serializable;

public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;

    public Item(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
