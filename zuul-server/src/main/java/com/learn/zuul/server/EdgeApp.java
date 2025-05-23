package com.learn.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Amandeep Bhatti
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class EdgeApp {

//  @LoadBalanced
//  @Bean
//  RestTemplate restTemplate() {
//    return new RestTemplate();
//  }

  public static void main(String[] args) {
    SpringApplication.run(EdgeApp.class, args);
  }
}

//@Component
//class DiscoveryClientSample implements CommandLineRunner {
//
//  @Autowired
//  private DiscoveryClient discoveryClient;
//
//  @Override
//  public void run(String... strings) throws Exception {
//    System.out.println(discoveryClient.description());
//    discoveryClient.getInstances("restaurant-service")
//        .forEach((ServiceInstance serviceInstance) -> {
//          System.out.println("Instance --> " + serviceInstance.getServiceId()
//              + "\nServer: " + serviceInstance.getHost() + ":" + serviceInstance.getPort()
//              + "\nURI: " + serviceInstance.getUri() + "\n\n\n");
//        });
//  }
//}