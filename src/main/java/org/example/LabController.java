package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LabController {
    AddressBookRepository addressBookRepository;
    BuddyInfoRepository buddyInfoRepository;
    @Autowired
    public LabController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

//    @GetMapping("/greeting")
//    public String addressBooks(@RequestParam(value = "bookId", defaultValue = "Hello, World") Long id, Model model) {
//        AddressBook addressBook = addressBookRepository.findAddressBookById(id);
//        model.addAttribute("bookId", addressBook);
//        return "greeting";
//    }


//    ***WORKS PERFECTLY***
//    @GetMapping("/greeting")
//    public String greetingForm(Model model) {
//        model.addAttribute("greeting", new Greeting());
//        return "greeting";
//    }
//
//    @PostMapping("/greeting")
//    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
//        model.addAttribute("greeting", greeting);
//        return "result";
//    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        AddressBook addressBook = new AddressBook();
        model.addAttribute("addressBook", addressBook);
        model.addAttribute("buddies", addressBook.buddies);
        return "greeting";
    }

//    @GetMapping("/addressBooks/{id}")
//    public String greetingForm(@RequestParam(value = "bookId") Long id, Model model) {
//        AddressBook addressBook = addressBookRepository.findAddressBookById(id);
//        model.addAttribute("addressBooks", addressBook);
//        model.addAttribute("buddies", addressBook.buddies);
//        return "greeting";
//    }

    @PostMapping("/addressBook")
    public String greetingSubmit(@ModelAttribute AddressBook addressBook, @ModelAttribute BuddyInfo buddyInfo, Model model) {
        model.addAttribute("addressBooks", addressBook);
        model.addAttribute("buddyInfos", buddyInfo);
        return "addressBook";
    }



//    @GetMapping("/addressBooks")
//    public String greetingForm(Model model) {
//        AddressBook addressBook = new AddressBook();
//        model.addAttribute("addressBooks", addressBook);
//        model.addAttribute("buddies", addressBook.buddies);
//        return "greeting";
//    }

    @RequestMapping(value="/addBuddy", method = RequestMethod.POST)
    public String addBuddy(AddressBook addressBook, @RequestParam String name, @RequestParam String number, Model model){
        model.addAttribute(addressBook);
        addressBook.addBuddy(name, number);
        return "buddies";
    }

//    @PostMapping("/result")
//    public String addBuddy(@RequestBody AddressBook addressBook, @RequestParam String name, @RequestParam String number, Model model){
//        model.addAttribute(addressBook);
//        addressBook.addBuddy(name, number);
//        return "buddies";
//    }

//    @PostMapping("/buddies")
//    public String addBuddy(@ModelAttribute AddressBook addressBook, @ModelAttribute BuddyInfo buddyInfo, Model model) {
//        model.addAttribute("addressBooks", addressBook);
//        model.addAttribute("buddyInfos", buddyInfo);
//        return "buddies";
//    }

//    @GetMapping("/buddyInfoes")
//    public String buddyInfoes(@RequestParam("id") Long id, Model model) {
//        BuddyInfo buddyInfo = buddyInfoRepository.findBuddyInfoById(id);
//        model.addAttribute("buddyInfo", buddyInfo);
//        return "buddyInfoes";
//    }
}
