package com.inventory.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.math.BigDecimal;

import com.inventory.management.service.ProductService;
import com.inventory.management.entity.*;

@SpringBootApplication
public class AiPoweredInventoryManagementSystemApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(
                		AiPoweredInventoryManagementSystemApplication.class,
                        args
                );
    }
}