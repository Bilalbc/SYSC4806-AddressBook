package org.example;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// java -cp .\target\Lab1-1.0-SNAPSHOT.jar org.example.AddressBook

/**
 * AddressBook Class for Lab 1
 * @author Bilal Chaudhry 101141634
 * @version 1.0
 */

@Entity
public class AddressBook {

    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> addressBook;

    @Id
    @GeneratedValue
    @Column (name="_id")
    private Long id;

    /**
     * Constructor to create an empty AddressBook
     */
    public AddressBook() {
        this.addressBook = new ArrayList<BuddyInfo>();
    }
    /**
     * Constructor to create Addressbook with a list of buddies
     * @param buddies : ArrayList of Buddies
     */
    public AddressBook(ArrayList<BuddyInfo> buddies) {
        addressBook.addAll(buddies);
    }

    /**
     * Method to add a Buddy to the AddressBook
     * @param buddy : BuddyInfo
     */
    public void addBuddy(BuddyInfo buddy) {
        this.addressBook.add(buddy);
    }

    /**
     * Getter for the AddressBook Object
     * @return AddressBook
     */
    public List<BuddyInfo> getAddressBook() {
        return this.addressBook;
    }

    public void setAddressBook(List<BuddyInfo> addressBook) {
        this.addressBook = addressBook;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void removeBuddy(long id) {
        addressBook.removeIf(b -> b.getId() == id);
    }

    public Long getId() {
        return id;
    }

/*    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        addressBook.addBuddy(new BuddyInfo("Bilal", "613-555-5555"));
        addressBook.addBuddy(new BuddyInfo("Kousha", "613-666-6666"));
        addressBook.addBuddy((new BuddyInfo("Akshay", "613-777-7777")));

        System.out.println(addressBook);

    }*/
}
