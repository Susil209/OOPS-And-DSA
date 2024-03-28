package com.java.SolidPrinciples.DependencyInversion.Good;

public class SubOperation implements CalculatorOperator{

    @Override
    public int calculate(int a, int b) {
        return a-b;
    }
}
