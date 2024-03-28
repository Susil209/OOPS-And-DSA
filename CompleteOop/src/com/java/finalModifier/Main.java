package com.java.finalModifier;

import com.java.finalModifier.generic.BaseClass;
import consumer.specific.ChildClass;
import external.util.Logger;

public class Main {
    public static void main(String[] args) {

        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("--------------------------");
        childReferredToAsBase.recommendedMethod();
        System.out.println("--------------------------");
        child.recommendedMethod();

        System.out.println("---------------------------");
        parent.recommendedStatic();
        System.out.println("--------------------------");
        childReferredToAsBase.recommendedStatic();
        System.out.println("--------------------------");
        child.recommendedStatic();

        System.out.println("--------------------------");
        BaseClass.recommendedStatic();
        ChildClass.recommendedStatic();


        System.out.println("----------------------------");
        String x = "Hello java";
        StringBuffer z = new StringBuffer("This is string buffer");
        doXYZ(x,10,z);
        System.out.println("After x = "+ x);
        System.out.println("After z ="+ z);


        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());
        tracker.append(", step 2 is xyz. ");
        Logger.logToConsole(tracker.toString());
        System.out.println("After logging tracker = "+ tracker);

    }

    private static void doXYZ(String x, int y,final StringBuffer z) {
        final String c = x+y;
        System.out.println("c = "+c);
        z.append(y);
//        z = new StringBuffer("new string");
    }
}
