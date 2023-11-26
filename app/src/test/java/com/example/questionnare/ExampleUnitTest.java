package com.example.questionnare;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for validating basic arithmetic operations.
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        // Arrange
        int operand1 = 2;
        int operand2 = 2;

        // Act
        int result = ArithmeticUtil.add(operand1, operand2);

        // Assert
        assertEquals("The addition result is correct", 4, result);
    }
}
