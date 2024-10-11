package com.ecommerce.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"admin", "default"})
public class AdminService {

    public void manageProducts() {
        System.out.println("Admin managing products...");
    }
}
