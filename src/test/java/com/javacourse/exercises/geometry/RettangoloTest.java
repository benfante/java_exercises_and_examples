package com.javacourse.exercises.geometry;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RettangoloTest {
    @Test
    void testEquals() {
        Rettangolo r1 = new Rettangolo(10, 20);
        Rettangolo r2 = new Rettangolo(20, 10);
        assertTrue(r1.equals(r2));
    }

    @Test
    void testNotEquals() {
        Rettangolo r1 = new Rettangolo(10, 20);
        Rettangolo r2 = new Rettangolo(20, 5);
        assertFalse(r1.equals(r2));
    }

    @Test
    void testHashCode() {
        Rettangolo r1 = new Rettangolo(10, 20);
        Rettangolo r2 = new Rettangolo(20, 10);
        assertTrue(r1.hashCode() == r2.hashCode());
    }
}
