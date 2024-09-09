package com.ltp.superstore.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ltp.superstore.Item;

@Repository
public class ItemRepository {

    private List<Item> items = new ArrayList<>();

    public Item getItem(int index) {
        return items.get(index);
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void updateItem(int index, Item item) {
        items.set(index, item);
    }

    public void removeItem(int index) {
        items.remove(index);
    }

}
