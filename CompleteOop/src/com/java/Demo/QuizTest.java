package com.java.Demo;

//interface Count
//{
//    short counter = 0;
//    void countUp();
//}

import java.util.Stack;

public class QuizTest {

//    int x = l, y = 6;
//    while(y--)
//    {
//        x++;
//    }
//    System.out.println("x = "+x +" y = "+y);


//    static boolean foo(char c)
//    {
//        System.out.print(c);
//        return true;
//    }


    //    public void countUp()
//    {
//        for (int x = 6; x>counter; x--, ++counter) /* Line 14 */
//        {
//            System.out.print(" " + counter);
//        }
//    }
//    final static short x = 2;
//    public static int y = 0;
//    public static void main(String[] args) {
//        for (int z=0; z < 4; z++)
//        {
//            switch (z)
//            {
//                case x: System.out.print("0 ");
//                default: System.out.print("def ");
//                case x-1: System.out.print("1 ");
//                    break;
//                case x-2: System.out.print("2 ");
//            }
//        }

//        int i = 0;
//        for (foo('A'); foo('B') && (i < 2); foo('C'))
//        {
//            i++;
//            foo('D');
//        }

//        QuizTest t = new QuizTest();
//        t.countUp();

//        class Foo
//        {
//            public int i = 3;
//        }
//        Object o = (Object)new Foo();
//        Foo foo = (Foo)o;
//        System.out.println("i = " + foo.i);
//}

    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        st.push('(');
        System.out.println(st.size());
    }
}
