package com.learn.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Amandeep Singh
 */
@SpringBootApplication
@EnableEurekaClient
public class RestaurantApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(RestaurantApp.class, args);
  }
}
