package org.example;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.example.CustomerProfileUpdater.updateCustomerProfiles;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Create a Map to store the customer profiles
        Map<Integer, CustomerProfile> customerProfiles = new HashMap<>();

        // Auto-generate the next customer ID and RFID number
        int nextCustomerId = 1001;
        long nextRfid = 2001L;

        // Ask the user to enter details for the existing customer profile
        System.out.println("Enter existing customer details:");

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        System.out.print("Enter customer joined date (yyyy-mm-dd): ");
        String dateString = scanner.next();
        Date customerJoinedDate = Date.valueOf(dateString);

        // Create and add the customer profile to the map with auto-generated customer ID and RFID
        CustomerProfile profile1 = new CustomerProfile(nextCustomerId++,
                customerName,
                address, nextRfid++,
                customerJoinedDate);
        customerProfiles.put(profile1.customerId, profile1);

        // Ask the user to enter details for the new customer profile
        System.out.println("\nEnter new customer details:");

        scanner.nextLine();

        System.out.print("Enter customer name: ");
        String newCustomerName = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String newAddress = scanner.nextLine();

        System.out.print("Enter customer joined date (yyyy-mm-dd): ");
        String newDateString = scanner.next();
        Date newCustomerJoinedDate = Date.valueOf(newDateString);

        // Create the new customer profile with auto-generated customerId and RFID
        CustomerProfile newProfile = new CustomerProfile(nextCustomerId++,
                newCustomerName,
                newAddress,
                nextRfid++,
                newCustomerJoinedDate);

        // Update the customer profile (will use UUID)
        Map<Integer, CustomerProfile> updatedProfiles = updateCustomerProfiles(customerProfiles,
                profile1.customerId,
                newProfile);

        // Printing the updated profiles
        System.out.println("\nUpdated Customer Profiles:");
        for (CustomerProfile profile : updatedProfiles.values()) {
            System.out.println(profile);
        }

        scanner.close();
    }
}
