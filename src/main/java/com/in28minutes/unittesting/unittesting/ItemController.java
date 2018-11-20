package com.in28minutes.unittesting.unittesting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;

@RestController
public class ItemController {
    
    @Autowired
    private ItemBusinessService businessService;
    
    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "Ball", 10, 100);
    }
    
    @GetMapping("/item-from-business-service")
    public Item itemForBusinessService(){
        return businessService.retrieveHardcodedItem();
    }
    
    @GetMapping("/item-from-database")
    public List<Item> retrieveAllItems(){
        return businessService.retrieveAllItems();
    }
}
