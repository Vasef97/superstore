package com.ltp.superstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ltp.superstore.Constants;
import com.ltp.superstore.Item;
import com.ltp.superstore.service.SuperstoreService;

@Controller
public class SuperstoreController {

    @Autowired
    SuperstoreService superstoreService;

    @GetMapping("/") // get formas ston syndesmo /
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("item", superstoreService.getItemById(id));
        model.addAttribute("categories", Constants.CATEGORIES); 
        return "form";
    }

    @PostMapping("/submitItem") // Post request stin forma kai eisagwgi tou neou item sto ArrayList mas
    public String handleSubmit(Item item, RedirectAttributes redirectAttributes) { 
                                                                                   
        superstoreService.submitItem(item);
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", superstoreService.getItems());
        return "inventory";
    }

    @GetMapping("/delete")
    public String deleteItem(@RequestParam String id, RedirectAttributes redirectAttributes) {
        int index = superstoreService.getItemIndex(id);
        if (index != Constants.NOT_FOUND) {
            superstoreService.removeItem(index); // remove item from list if found
            redirectAttributes.addFlashAttribute("status", Constants.DELETE_STATUS);
        }
        return "redirect:/inventory";
    }

}
