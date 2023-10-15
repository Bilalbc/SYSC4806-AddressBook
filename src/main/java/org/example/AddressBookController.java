package org.example;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// controller wants us to return view templates
// restcontroller allows us to return json objects
@Controller
public class AddressBookController {

    private final AddressBookRepository repo;

    AddressBookController(AddressBookRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/")
    public String home() {
        System.out.println("AddressBook Controller... passing through");

        return "home";
    }

    @RequestMapping(value = "/addressBook")
    public String getAddressBook(@RequestParam(value = "id") long id, Model model) {
        AddressBook addressBook = repo.findById(id);

        if(addressBook != null) {
            model.addAttribute("id", addressBook.getId());
            model.addAttribute("buddies", addressBook.getAddressBook());
        } else {
            model.addAttribute("id", 0);
        }

        return "addressBook";
    }

    @RequestMapping(value = "/addressBook/new")
    public String getAddressBook(Model model) {
        AddressBook newBook = new AddressBook();

        repo.save(newBook);

        model.addAttribute("id", newBook.getId());
        model.addAttribute("buddies", newBook.getAddressBook());

        return "addAddressBook";
    }

    @Transactional
    @RequestMapping(value = "/addressBook/buddy/remove")
    public String removeBuddy(@RequestParam(value = "address_id") long address_id,
                              @RequestParam(value = "buddy_id") long buddy_id,  Model model) {
        AddressBook addressBook = repo.findById(address_id);
        addressBook.removeBuddy(buddy_id);

        model.addAttribute("id", address_id);
        model.addAttribute("buddies", addressBook.getAddressBook());

        return "removeBuddy";
    }

    @Transactional
    @RequestMapping(value = "/addressBook/buddy/add")
    public String addBuddy(@RequestParam(value = "address_id") long address_id,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "phoneNumber") String phoneNumber,
                           Model model ) {
        AddressBook addressBook = repo.findById(address_id);
        BuddyInfo newBuddy = new BuddyInfo(name, phoneNumber);

        addressBook.addBuddy(newBuddy);

        model.addAttribute("id", address_id);
        model.addAttribute("buddies", addressBook.getAddressBook());

        return "addBuddy";
    }


}
