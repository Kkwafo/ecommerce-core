package com.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ecommerce.service.AdminService;
import com.ecommerce.service.CustomerService;
import com.ecommerce.service.SupportService;

@Configuration
public class ProfileConfiguration {

    @Bean
    @Profile("admin")
    public AdminService adminService() {
        return new AdminService();
    }

    @Bean
    @Profile("customer")
    public CustomerService customerService() {
        return new CustomerService();
    }

    @Bean
    @Profile("support")
    public SupportService supportService() {
        return new SupportService();
    }
}
