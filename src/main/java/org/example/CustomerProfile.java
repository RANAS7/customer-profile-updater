package org.example;

import java.sql.Date;
import java.util.UUID;

public class CustomerProfile {
    int customerId;
    UUID newCustomerId;
    String customerName;
    String address;
    long rfidNumber;
    Date customerJoinedDate;

    // Constructor
    public CustomerProfile(int customerId,
                           String customerName,
                           String address,
                           long rfidNumber,
                           Date customerJoinedDate) {
        this.customerId = customerId;
        this.newCustomerId = null;  // will be set later
        this.customerName = customerName;
        this.address = address;
        this.rfidNumber = rfidNumber;
        this.customerJoinedDate = customerJoinedDate;
    }

    // Constructor for new customers
    public CustomerProfile(String customerName,
                           String address,
                           long rfidNumber,
                           Date customerJoinedDate) {
        this.customerId = -1;
        this.newCustomerId = UUID.randomUUID();
        this.customerName = customerName;
        this.address = address;
        this.rfidNumber = rfidNumber;
        this.customerJoinedDate = customerJoinedDate;
    }

    @Override
    public String toString() {
        return "CustomerProfile{" +
                "customerId=" + customerId +
                ", newCustomerId=" + newCustomerId +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", rfidNumber=" + rfidNumber +
                ", customerJoinedDate=" + customerJoinedDate +
                '}';
    }
}
