package service;

import model.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private final List<Item> items = new ArrayList<>();

    public void addItem(String name) {
        items.add(new Item(name));
    }

    public int getCount() {
        return items.size();
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            output.writeObject(items);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(fileName))) {
            Object data = input.readObject();
            if (!(data instanceof List<?>)) {
                throw new IOException("The saved file does not contain an item list.");
            }

            List<?> loadedItems = (List<?>) data;
            List<Item> checkedItems = new ArrayList<>();
            for (Object value : loadedItems) {
                if (!(value instanceof Item)) {
                    throw new IOException("The saved file contains invalid item data.");
                }
                checkedItems.add((Item) value);
            }

            items.clear();
            items.addAll(checkedItems);
        }
    }
}
