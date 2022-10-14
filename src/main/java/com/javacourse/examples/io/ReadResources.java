package com.javacourse.examples.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadResources {
    public static void main(String[] args) throws IOException {
        try (Reader reader = new BufferedReader(
            new InputStreamReader(ReadResources.class.getResourceAsStream("/com/javacourse/exercises/jdbc/database.properties")))) {
                read(reader);
        }
        
    }

    static void read(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        while(line != null) {
            System.out.println(line);
            line = br.readLine();
        }
    }
}
