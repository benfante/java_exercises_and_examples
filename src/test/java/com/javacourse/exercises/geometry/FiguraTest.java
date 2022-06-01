package com.javacourse.exercises.geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class FiguraTest {
    @Test
    void testEquals() {
        assertEquals(
            new Triangolo(10, 20),
            new Triangolo(20, 10));
    }

    @Test
    void testEqualsWithDifferentFigures() {
        assertNotEquals(
            new Triangolo(10, 20),
            new Quadrato(10));
    }

}
