package com.javacourse.examples.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        try (Reader reader = new BufferedReader(
            new InputStreamReader(getSourceStream()))) {
                read(reader);
        }
        
    }

    static InputStream getSourceStream() throws FileNotFoundException {
        File homeDir = new File(System.getProperty("user.home"));        
        File file = new File(homeDir, "/tmp/prova.txt");
        return new FileInputStream(file);
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