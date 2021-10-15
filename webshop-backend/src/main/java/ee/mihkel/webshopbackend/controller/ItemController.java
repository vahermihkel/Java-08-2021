package ee.mihkel.webshopbackend.controller;

import ee.mihkel.webshopbackend.exception.ItemNotFoundException;
import ee.mihkel.webshopbackend.model.Item;
import ee.mihkel.webshopbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:3000")
public class ItemController {

    @Autowired
    ItemService itemService;

    // muudame tagastatava tüübi ära ja paneme Itemite List asemel
    // return järgi tagastame kõik esemed andmebaasist

    // localhost:8080/items

    // fetch sees tehakse päring http://localhost:8080/items
    @GetMapping("items")
    // response on List<Item>
    public List<Item> getItems() {
        return itemService.getItems();
    }

    // localhost:8080/add-item - post - body
    @PostMapping("add-item")
                        // nõuame body front-endilt mis on Item kujul
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
        // võime void lihtsalt teha ja lisada andmebaasi
    }

    //  localhost:8080/delete-item/
    @DeleteMapping("delete-item/{id}")
                                // url muutuja
    public List<Item> deleteItem(@PathVariable Long id) throws ItemNotFoundException {
        try {
            itemService.deleteItem(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new ItemNotFoundException();
        }
        return itemService.getItems();
    }

    //  localhost:8080/edit-item
    @PostMapping("edit-item")
    public void editItem(@RequestBody Item item) {
        itemService.editItem(item);
    }

    @GetMapping("view-item/{id}")
    public Item getOneItem(@PathVariable Long id) throws ItemNotFoundException {
        return itemService.getOneItem(id);
    }
}


// kustutamine
// muutmine
// ühe eseme vaatamine --
