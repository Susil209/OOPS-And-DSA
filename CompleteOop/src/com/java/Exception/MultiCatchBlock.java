package com.java.Exception;

public class MultiCatchBlock {
    public static void main(String[] args) {
        try{
             //System.out.println(10/0); // java.lang.ArithmeticException: / by zero
            String s = null;
            System.out.println(s.length());// java.lang.NullPointerException:
            // Cannot invoke "String.length()" because "<local1>" is null
        }

        catch (ArithmeticException | NullPointerException e) {
            System.out.println(e);
        }

//        catch (ArithmeticException | Exception e) {
//            System.out.println(e);
//        }

        // CE:  error: Alternatives in a multi-catch statement cannot be related by subclassing
        //        catch (ArithmeticException | Exception e) {
        //                                     ^
        //  Alternative ArithmeticException is a subclass of alternative Exception
    }
}
