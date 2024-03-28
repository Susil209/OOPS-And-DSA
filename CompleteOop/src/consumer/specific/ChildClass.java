package consumer.specific;

import com.java.finalModifier.generic.BaseClass;

public class ChildClass extends BaseClass {
    @Override
    protected void optionalMethod() {
        System.out.println("[ChildClass.optionalMethod]: Extra stuff.");
        super.optionalMethod();
    }

//    @Override
//    public void recommendedMethod() {
//        System.out.println("[ChildClass.recommendedMethod]: I'll do things my way.");
//        optionalMethod();
//    }

    public static void recommendedStatic(){
        System.out.println("[BaseClass.recommendedStatic]: Best way to do it.");
        optionalStatic();
//        mandatoryStatic();
    }
}
