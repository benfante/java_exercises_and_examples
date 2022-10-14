package com.javacourse.examples.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class WriteFile {

    public static void main(String[] args) throws IOException {
        try (Writer fw = new FileWriter("/home/lucio/tmp/nuovofile.txt");) {
            write(fw);
            fw.write("Prova ancora");
        }
    }

    private static void write(Writer writer) {
        PrintWriter pw = new PrintWriter(new BufferedWriter(writer));
        pw.println("Prima riga");
        pw.println("Seconda riga");
        pw.println("Terza riga");
        pw.println("Quarta riga");
        pw.println("Ciao riga");
        pw.flush();
    }
}