package com.java.Java8Features.MethodReference;

@FunctionalInterface
interface Messagable{
    void getMessage(String msg);
}

class Message{
    Message(String msg){
        System.out.println(msg);
    }
}

public class ConstructRefEx1 {
    public static void main(String[] args) {
        //Messagable hello = (m) -> new Message(m); // lambda exp
        Messagable hello  = Message::new; // constructor ref
        hello.getMessage("Hello");
    }
}
