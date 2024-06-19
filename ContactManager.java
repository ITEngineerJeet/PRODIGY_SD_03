/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.contactmanager;

/**
 *
 * @author HP
 */
import java.util.Scanner;
import java.util.ArrayList;

class Contact
{
    //Declaring the Base Variables
    private String name;
    private String phoneNumber;
    private String email;
    
    //Parametarized Constructor to initialize the details 
    public Contact(String name, String phoneNumber, String email)
    {
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
    
    //Returns and Stores the provided Name 
    public String getName()
    {
        return name;
    }
    
    //For Updating the Name if required 
    public void setName(String name) 
    {
        this.name = name;
    }
 
    ////Returns and Stores the provided phoneNumber 
    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    //For updating the phoneNumber if required 
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }
    
    ////Returns and Stores the provided Email
    public String getEmail() 
    {
        return email;
    }

    //For updating the email if required 
    public void setEmail(String email) 
    {
        this.email = email;
    }

    @Override
    public String toString() 
    {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}


public class ContactManager 
{
    private ArrayList<Contact> contacts; //ArrayList stores Details in Memory 
    private Scanner sc;

    //Function creating objects of ArrayList and Scanner class
    public ContactManager() 
    {
        contacts = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    //Function to Add Contacts to the List 
    public void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        Contact newContact = new Contact(name, phoneNumber, email); //Object of Contact Class 
        contacts.add(newContact);
        System.out.println("Contact added successfully.");
    }

    //Function to View the Contacts
    public void viewContacts() 
    {
        if (contacts.isEmpty()) 
        {
            System.out.println("No contacts to display.");
        } 
        else 
        {
            System.out.println("List of contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    //Function to Update the Contacts
    public void updateContact() 
    {
        if (contacts.isEmpty()) 
        {
            System.out.println("No contacts to update.");
            return;
        }

        System.out.print("Enter the name of the contact to update: ");
        String name = sc.nextLine();

        boolean found = false;
        for (Contact contact : contacts) //For-Each Loop 
        {
            if (contact.getName().equalsIgnoreCase(name)) //Ignoring the Case of the Input for Update Purpose
            {
                System.out.print("Enter new phone number: ");
                String newPhoneNumber = sc.nextLine();
                System.out.print("Enter new email: ");
                String newEmail = sc.nextLine();

                contact.setPhoneNumber(newPhoneNumber);
                contact.setEmail(newEmail);
                System.out.println("Contact updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) 
        {
            System.out.println("Contact not found.");
        }
    }

    //Function to Delete the Contacts
    public void deleteContact() 
    {
        if (contacts.isEmpty()) 
        {
            System.out.println("No contacts to delete.");
            return;
        }

        System.out.print("Enter the name of the contact to delete: ");
        String name = sc.nextLine();

        Contact foundContact = null;
        for (Contact contact : contacts) 
        {
            if (contact.getName().equalsIgnoreCase(name)) 
            {
                foundContact = contact;
                break;
            }
        }

        if (foundContact != null) 
        {
            contacts.remove(foundContact);
            System.out.println("Contact deleted successfully.");
        } 
        else 
        {
            System.out.println("Contact not found.");
        }
    }

    public void close() 
    {
        sc.close();
    }

    public static void main(String[] args) 
    {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) 
            {
                case 1:
                    contactManager.addContact();
                    break;
                case 2:
                    contactManager.viewContacts();
                    break;
                case 3:
                    contactManager.updateContact();
                    break;
                case 4:
                    contactManager.deleteContact();
                    break;
                case 5:
                    contactManager.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
}
}

/* The Solution of the code goes like this when executed 
   --- Contact Management System ---
1. Add Contact
2. View Contacts
3. Update Contact
4. Delete Contact
5. Exit
Enter your choice: 1
Enter name: Taj
Enter phone number: 9874110482
Enter email: sartajgill2003@yahoo.in
Contact added successfully.

--- Contact Management System ---
1. Add Contact
2. View Contacts
3. Update Contact
4. Delete Contact
5. Exit
Enter your choice: 2
List of contacts:
Name: Jeet, Phone: 9073821077, Email: jeethaitkiit@gmail.com
Name: Taj, Phone: 9874110482, Email: sartajgill2003@yahoo.in

--- Contact Management System ---
1. Add Contact
2. View Contacts
3. Update Contact
4. Delete Contact
5. Exit
Enter your choice:  */