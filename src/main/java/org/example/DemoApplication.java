package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

//	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(AddressBookRepository repo) {
//		return (args) -> {
//			AddressBook ab = new AddressBook(1L, "First");
//			BuddyInfo b1 = new BuddyInfo(1L, "Sahil", "613");
//			BuddyInfo b2 = new BuddyInfo(2L, "George", "801");
//			BuddyInfo b3 = new BuddyInfo(3L, "Seyr", "050");
//
////
////			BuddyInfo b2 = new BuddyInfo();
////			b2.setId(Long.valueOf(2));
////			b2.setName("George");
////			b2.setNumber("801");
////
////			BuddyInfo b3 = new BuddyInfo();
////			b3.setId(Long.valueOf(3));
////			b3.setName("Seyr");
////			b3.setNumber("050");
////
//			ab.addBuddy(b1);
//			ab.addBuddy(b2);
//			ab.addBuddy(b3);
////			repo.save(new AddressBook("First"));
//			repo.save(ab);
//
//			log.info("AddressBook found with findAll(): ");
//			log.info("----------------------------------");
//			for (AddressBook addressBook : repo.findAll()) {
//				log.info(addressBook.toString());
//			}
//			log.info("");
//
//			AddressBook addressBook = repo.findAddressBookById(1L);
////			addressBook.addBuddy(b1);
////			addressBook.addBuddy(b2);
////			addressBook.addBuddy(b3);
//			log.info("AddressBook found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(addressBook.toString());
//			log.info(addressBook.buddyToString());
//			log.info("");
//
//			log.info("AddressBook found with findByName(First):");
//			log.info("--------------------------------------------");
//			repo.findAddressBookByBookName("First").forEach(first -> {
//				log.info(first.toString());
//			});
//			log.info("");
//		};
//	}
}
