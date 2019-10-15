package com.javacourse.exercises.base;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwapVariablesTest {

	@Test
	public void testSwap() {
		SwapVariables swapVariables = new SwapVariables(12, 3);
		swapVariables.swap();
		assertEquals(3, swapVariables.a);
		assertEquals(12, swapVariables.b);
	}

}
