package com.ltp.superstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.superstore.Constants;
import com.ltp.superstore.Item;
import com.ltp.superstore.repository.ItemRepository;

@Service
public class SuperstoreService {

    @Autowired
    ItemRepository itemRepository;

    public Item getItem(int index) {
        return itemRepository.getItem(index);
    }

    public List<Item> getItems() {
        return itemRepository.getItems();
    }

    public void addItem(Item item) {
        itemRepository.addItem(item);
    }

    public void updateItem(int index, Item item) {
        itemRepository.updateItem(index, item);
    }

    public void removeItem(int index) {
        itemRepository.removeItem(index);
    }

    public Item getItemById(String id) {
        int index = getItemIndex(id);
        return index == Constants.NOT_FOUND ? new Item() : getItem(index); 
                                                                           
    }

    public void submitItem(Item item) {
        int index = getItemIndex(item.getId());
        if (index == Constants.NOT_FOUND) { 
                                            
            addItem(item);
        } else {
            updateItem(index, item); 
        }

    }

    public int getItemIndex(String id) {
        for (int i = 0; i < getItems().size(); i++) {
            if (getItems().get(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

}
