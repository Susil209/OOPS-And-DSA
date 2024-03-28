package external.util;

import com.java.JavaLangPackage.ImmutableClass.Person;

import java.util.Arrays;

public class LivingPerson extends Person {

    public LivingPerson(String name, Person[] kids) {
        super(name, null, kids == null ? new Person[10] : Arrays.copyOf(kids, 10));
    }

    public LivingPerson(Person person) {
        super(person);
    }

    @Override
    public String getDob() {
        return null;
    }

    public void addKid(Person person) {
        for (int i=0; i< kids.length ;i++) {
            if(kids[i] == null){
                kids[i] = person;
                break;
            }
        }
    }
}
