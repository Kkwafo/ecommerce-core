package com.ecommerce.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"support", "default"}) 
public class SupportService {

    public void assistCustomer() {
        System.out.println("Support assisting customer...");
    }
}
