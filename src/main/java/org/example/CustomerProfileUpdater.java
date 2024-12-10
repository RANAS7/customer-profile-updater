package org.example;

import java.util.Map;
import java.util.UUID;

public class CustomerProfileUpdater {
    public static Map<Integer, CustomerProfile> updateCustomerProfiles(Map<Integer, CustomerProfile> customerProfiles, Integer customerId, CustomerProfile newCustomerProfile) {
        if (customerId != null && customerProfiles.containsKey(customerId)) {
            customerProfiles.remove(customerId);
            newCustomerProfile.newCustomerId = UUID.randomUUID();
            customerProfiles.put(newCustomerProfile.customerId, newCustomerProfile);
        } else if (customerId == null) {
            customerProfiles.put(newCustomerProfile.customerId, newCustomerProfile);
        }
        return customerProfiles;
    }
}
