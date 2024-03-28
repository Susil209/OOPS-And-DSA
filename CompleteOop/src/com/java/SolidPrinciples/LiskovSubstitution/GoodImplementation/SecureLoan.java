package com.java.SolidPrinciples.LiskovSubstitution.GoodImplementation;

public interface SecureLoan extends LoanPayment {
    void foreCloseLoan();
}
