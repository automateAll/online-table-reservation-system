package com.learn.user.resources.docker;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Sourabh Sharma
 */
@Category(DockerIT.class)
public class UserAppDockerIT {

    /**
     *
     * @throws IOException
     */
    @Test
    public void testConnection() throws IOException {
        String baseUrl = System.getProperty("service.url");
        System.out.println("Base URL is: " + baseUrl);
        URL serviceUrl = new URL(baseUrl + "v1/user/1");
        System.out.println("Full URL: " + serviceUrl);
        HttpURLConnection connection = (HttpURLConnection) serviceUrl.openConnection();
        int responseCode = connection.getResponseCode();
        System.out.println("Response code: " + responseCode);
        assertEquals(200, responseCode);
    }
}
