package com.learn.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Amandeep Singh
 */
@SpringBootApplication
@EnableEurekaServer
public class App {

  /**
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
