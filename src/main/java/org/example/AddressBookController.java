package org.example;

import jakarta.transaction.Transactional;
import org.springframework.http.MediaType;
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

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String home() {
        System.out.println("AddressBook Controller... passing through");

        return "home";
    }

    @RequestMapping(value = "/addressBook", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @RequestMapping(value = "/addressBook/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createAddressBook(Model model) {
        AddressBook newBook = new AddressBook();

        repo.save(newBook);

        model.addAttribute("id", newBook.getId());
        model.addAttribute("buddies", newBook.getAddressBook());

        return "addAddressBook";
    }

    @Transactional
    @RequestMapping(value = "/addressBook/buddy/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    public String removeBuddy(@RequestParam(value = "address_id") long address_id,
                              @RequestParam(value = "buddy_id") long buddy_id,  Model model) {
        AddressBook addressBook = repo.findById(address_id);
        addressBook.removeBuddy(buddy_id);

        model.addAttribute("id", address_id);
        model.addAttribute("buddies", addressBook.getAddressBook());

        return "removeBuddy";
    }

    @Transactional
    @RequestMapping(value = "/addressBook/buddy/add", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @RequestMapping(value = "/test/addressBook", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AddressBook getAddressBookTest(@RequestParam(value = "id") long id, Model model) {
        AddressBook addressBook = repo.findById(id);

        if(addressBook != null) {
            model.addAttribute("id", addressBook.getId());
            model.addAttribute("buddies", addressBook.getAddressBook());
        } else {
            model.addAttribute("id", 0);
        }

        return addressBook;
    }
}
