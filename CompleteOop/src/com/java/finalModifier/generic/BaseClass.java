package com.java.finalModifier.generic;

public class BaseClass {
    public final void recommendedMethod() {
        System.out.println("[BaseClass.recommendedMethod]: Best way to do it.");
        optionalMethod();
        mandatoryMethod();
    }

    // protected - only subclasses outside package and in current package
    protected void optionalMethod() {
        System.out.println("[BaseClass.optionalMethod]: Customizable Optional Method.");
    }

    // private - only within the class
    private void mandatoryMethod() {
        System.out.println("[BaseClass.mandatoryMethod]: NON-NEGOTIABLE!");
    }

    public static void recommendedStatic(){
        System.out.println("[BaseClass.recommendedStatic]: Best way to do it.");
        optionalStatic();
        mandatoryStatic();
    }

    protected static void optionalStatic(){
        System.out.println("[BaseClass.optionalStatic]: Optional.");
    }

    private static void mandatoryStatic(){
        System.out.println("[BaseClass.mandatoryStatic]: MANDATORY.");
    }
}
