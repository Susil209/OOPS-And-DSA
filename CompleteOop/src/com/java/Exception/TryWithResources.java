package com.java.Exception;

import java.io.BufferedReader;
import java.io.FileReader;

public class TryWithResources {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new FileReader("abc.txt")))
        {
            // br = new BufferedReader(new FileReader("output.txt"));
        }
    }
}

// CE : .\TryWithResources.java:10: error: auto-closeable resource br may not be assigned