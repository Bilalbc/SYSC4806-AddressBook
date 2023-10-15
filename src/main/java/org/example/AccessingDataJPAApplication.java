/*
package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJPAApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJPAApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJPAApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoBuddyInfo(BuddyInfoRepository buddyInfoRepository, AddressBookRepository addressBookRepository) {

        return (args) -> {
            BuddyInfo a = new BuddyInfo("Bilal", "613 666 6666");
            BuddyInfo b = new BuddyInfo("Kousha", "613 777 7777");
            BuddyInfo c = new BuddyInfo("Akshay", "613 888 8888");

            buddyInfoRepository.save(a);
            buddyInfoRepository.save(b);
            buddyInfoRepository.save(c);

            log.info("=============================================");
            log.info("BuddyInfo Tests");
            log.info("=============================================");

            log.info("Buddies found with findAll()");
            log.info("-------------------------------");
            for (BuddyInfo buddyInfo : buddyInfoRepository.findAll()) {
                log.info(buddyInfo.toString());
            }

            BuddyInfo buddyInfo = buddyInfoRepository.findById(1L);
            log.info("Buddy found with findById(1L):");
            log.info("--------------------------------");
            log.info(buddyInfo.toString());
            log.info("");

            log.info("Buddies found with findByName('Bilal'):");
            log.info("--------------------------------------------");
            buddyInfoRepository.findByName("Bilal").forEach(Bilal -> {
                log.info(Bilal.toString());
            });

            log.info("=============================================");
            log.info("AddressBook Tests");
            log.info("=============================================");

            AddressBook ab = new AddressBook();

            ab.addBuddy(a);
            ab.addBuddy(b);
            ab.addBuddy(c);

            addressBookRepository.save(ab);

            log.info("AddressBook found with findAll()");
            for (AddressBook addressBook : addressBookRepository.findAll()) {
                log.info(addressBook.toString());
            }

            AddressBook addressBook = addressBookRepository.findById(1L);
            log.info("AddressBook found with findById(1L):");
            log.info("--------------------------------");
            log.info(addressBook.toString());
            log.info("");
        };

    }


}
*/
