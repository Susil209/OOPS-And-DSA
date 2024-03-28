package com.java.SolidPrinciples.DependencyInversion.Good;

/**
 * So we will have this class but it will be taken care
 * via interface implementation.
 *
 */
public class AddOperation implements CalculatorOperator{

    @Override
    public int calculate(int a, int b) {
        return a+b;
    }
}
