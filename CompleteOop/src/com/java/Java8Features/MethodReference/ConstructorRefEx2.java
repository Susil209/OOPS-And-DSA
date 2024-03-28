package com.java.Java8Features.MethodReference;

@FunctionalInterface
interface Interf{
    Sample get(String s);
}

class Sample{
    private final String s;
    Sample(String s){
        this.s = s;
    }

    void info(){
        System.out.println("The req arg is "+s);
    }
}


public class ConstructorRefEx2 {
    public static void main(String[] args) {
        // Interf i = (s) -> new Sample(s); // lambda
        Interf i = Sample::new; // Constructor arg
        i.get("Hello").info();
    }
}
