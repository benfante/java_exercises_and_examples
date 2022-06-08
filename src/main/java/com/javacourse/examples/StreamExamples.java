package com.javacourse.examples;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

import com.javacourse.examples.objects.Person;

public class StreamExamples {
    private Calendar cal = Calendar.getInstance();
    private Random random = new Random();

    public static void main(String[] args) {
        StreamExamples examples = new StreamExamples();

        System.out.println(Arrays.toString(examples.aFirstExample()));
        System.out.println(Arrays.toString(examples.aParallelStream()));
    }

    public String[] aFirstExample() {
        return Arrays.stream(buildPersons())
            .filter(person -> person.getLastName().startsWith("R"))
            .sorted(Comparator.comparing(person -> person.getAge().get()))
            .map(Person::getFullName)
            .collect(Collectors.toList())
            .toArray(new String[] {});
    }

    public String[] aParallelStream() {
        return Arrays.stream(buildPersons()).parallel()
            .filter(person -> person.getLastName().startsWith("R"))
            .sorted(Comparator.comparing(person -> person.getAge().get()))
            .map(Person::getFullName)
            .collect(Collectors.toList())
            .toArray(new String[] {});
    }

    private Person[] buildPersons() {
        return new Person[] {
            new Person("Mario", "Rossi", getRandomDate()),
            new Person("Giovanna", "Bianchi", getRandomDate()),
            new Person("Sandra", "Neri", getRandomDate()),
            new Person("Carlo", "Verdi", getRandomDate()),
            new Person("Massimo", "Bianco", getRandomDate()),
            new Person("Maria", "Rossi", getRandomDate()),
            new Person("Chiara", "Rosi", getRandomDate())
        };
    }

    private Date getRandomDate() {
        cal.set(
            random.nextInt(1970, 2010),
            random.nextInt(0, 12),
            random.nextInt(1, 32));
        return cal.getTime();
    }
}