package com.java.introduction;

public class AbstractMethodExample {
    public abstract class Vehicle{
        abstract public int noOfWheels();

    }

    class Bus extends Vehicle{
        @Override
        public int noOfWheels() {
            return 7;
        }
    }

    class Auto extends Vehicle{
        @Override
        public int noOfWheels() {
            return 3;
        }
    }



}


