package com.java.JavaLangPackage.ImmutableClass;

import java.util.Arrays;

// creating immutable class

public class Person {

    // 1. Make instance field private and final
    private final String name;
    private final String dob;
    protected final Person[] kids;

    // 4. Use any constructor or factory method to set data,
    // making copies of mutable reference data
    public Person(String name, String dob, Person[] kids) {
        this.name = name;
        this.dob = dob;
        this.kids = (kids == null) ? null : Arrays.copyOf(kids,kids.length);
    }

    public Person(String name, String dob) {
        this(name, dob, null);
    }

    // copy constructor
    protected Person(Person person) {
//        this.name = person.name;
//        this.dob = person.dob;
//        this.kids = person.kids;

        // defensive copies to have immutability
        this(person.getName(),person.getDob(),person.getkids());
    }

    public String getName() {
        return name;
    }



    public String getDob() {
        return dob;
    }


    // 3. create defensive copies of any getter
    public final Person[] getkids() {
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

    // 2. Don't define any setter method

    //    public void setDob(String dob) {
//        this.dob = dob;
//    }

    //    public void setName(String name) {
//        this.name = name;
//    }

//    public void setkids(Person[] kids) {
//        this.kids = kids;
//    }

    @Override
    public String toString() {
        String kidString = "n/a";
        if(kids !=null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(",", names);
        }
        return name + ", dob = "+ getDob() + ", kids = " + kidString;
    }
}
