package com.java.Map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) throws Exception {
        // Create a Properties object
        Properties p = new Properties();

        // Load properties from a file
        FileInputStream fis = new FileInputStream("CompleteOop/file.properties");
        p.load(fis);
        fis.close();

        // Access properties
        System.out.println(p); // {score=4321, password=hjbkvos990, port=8080, username=susil}
        String s = p.getProperty("score");
        System.out.println(s); // 4321

        // Modify and save properties
        p.setProperty("port", "8080");

        FileOutputStream fos = new FileOutputStream("CompleteOop/file.properties");
        p.store(fos, "Updated by Susil Nayak in Java");
        fos.close();

    }
}
