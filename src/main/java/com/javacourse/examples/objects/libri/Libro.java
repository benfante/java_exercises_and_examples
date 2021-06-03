package com.javacourse.examples.objects.libri;

public class Libro {
    private static final int MAX_PAGES;

    static {
        MAX_PAGES = 100;
    }

    private final int numeroPagine;
    private final String title;
    private final String author;

    public Libro(final int numeroPagine, final String title, final String author) {
        if (numeroPagine > MAX_PAGES) {
            // genera errore
        }
        this.numeroPagine = numeroPagine;
        this.title = title;
        this.author = author;
    }

    public static void main(String[] args) {
        final Libro l = new Libro(50, "Dieci Piccoli Indiani", "Agatha Christie");
        // ci asspettiamo che la variabile l non venga più riassegnata

        // l = new Libro(20, "", "");


    }

}