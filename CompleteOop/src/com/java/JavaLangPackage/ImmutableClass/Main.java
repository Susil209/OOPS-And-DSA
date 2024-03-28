package com.java.JavaLangPackage.ImmutableClass;

import external.util.LivingPerson;
import external.util.PersonOfInterest;

public class Main {
    public static void main(String[] args) {
        Person jane = new Person("Jane", "01/10/1980");
        Person jimmy = new Person("Jimmy", "02/07/1983");
        Person john = new Person("John", "03/09/1988");

        Person[] jamesKids = {jane, jimmy, john};
        Person james = new Person("James", "23/01/1910", jamesKids);
        System.out.println(james); // James, dob = 23/01/1910, kids = Jane,Jimmy,John


        Person[] kids =  james.getkids();
        kids[0] = jimmy;
        kids[1] = new Person("Thor","09/12/1990");
        System.out.println(james); // James, dob = 23/01/1910, kids = Jane,Jimmy,John

        // The result won't change as we are using defensive copies in constructor to attend immutability

        LivingPerson jamesLiving = new LivingPerson(james.getName(),james.getkids());
        System.out.println(jamesLiving);

        LivingPerson thor = new LivingPerson("Thor",null);
        jamesLiving.addKid(thor);
        System.out.println(jamesLiving);

        PersonOfInterest jamesCopy = new PersonOfInterest(james);
        System.out.println(jamesCopy); // James, dob = 23/01/1910, kids = Jane,Jimmy,John

        kids = jamesCopy.getkids();
        kids[1] = thor;
        System.out.println(jamesCopy); // James, dob = 23/01/1910, kids = Jane,Thor,John
        System.out.println(james); // James, dob = 23/01/1910, kids = Jane,Jimmy,John

        // Due to defensive copy made in constructor we can get immutability
        // and changes made in james copy don't affect james
    }
}
