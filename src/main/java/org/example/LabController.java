package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LabController {
    AddressBookRepository addressBookRepository;
    BuddyInfoRepository buddyInfoRepository;
    @Autowired
    public LabController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/greeting")
    public String addressBooks(@RequestParam(value = "bookId", defaultValue = "Hello, World") Long id, Model model) {
        AddressBook addressBook = addressBookRepository.findAddressBookById(id);
        model.addAttribute("bookId", addressBook);
        return "greeting";
    }

//    @GetMapping("/buddyInfoes")
//    public String buddyInfoes(@RequestParam("id") Long id, Model model) {
//        BuddyInfo buddyInfo = buddyInfoRepository.findBuddyInfoById(id);
//        model.addAttribute("buddyInfo", buddyInfo);
//        return "buddyInfoes";
//    }
}
