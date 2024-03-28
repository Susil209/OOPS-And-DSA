package com.java.SolidPrinciples.DependencyInversion.Good;

/**
 * This is low level modules interface so anything
 * to invoke in low level modules needs to go via this interface
 * by this we will achieve both loosely couple between high level and low level module
 * and abstraction as well.
 */
public interface CalculatorOperator {
    public int calculate(int a,int b);
}
