import java.lang.*;
import java.util.*;

class pair{
    int a,b;
    pair(int a, int b){
        this.a = a;
        this.b = b;
    }

    void fun1(){
        int a =1;
        int b = 2;
        int sum = this.a + b;
        System.out.println("this is fun1 " + sum);
        this.fun2(sum);
    }

    void fun2(int sum2){
        System.out.println(("this is fun2 sum: " + sum2));
    }
}

class grandParent {
    static String schoolname;
    String name;
    grandParent(){
        System.out.println("grandParent constructor");
    }
    grandParent(int i){
        System.out.println("grandParent constructor i " + i);
    }
    void display() {
        System.out.println("Inside grandParent class");
    }
    void grandpadisplay() {
        System.out.println("Inside grandParent display2 class");
    }
}

class Parent extends grandParent{
    static String schoolname;

    static {
        System.out.println("I am in static block");
    }
    // both, static block and static variables are initialised and executed
    // only when the very first object of the class is created.
    String name;
    Parent(){
        this (100); // must be the first statement in constructor. kind of like super.
        // super() is used to call the constructor of immediate parent.
        // this() is used to call the constructor of the same object.

//        super(89); // this is redundant. since parent extends grandparent,
//        grandparent's constructor will be executed first anyways.
//        also, both this() and super() have to be the first statements, which is not possible. only one can be first.
//        but luckily, super() will be executed implicitly anyways, hence it can be ignored.
        System.out.println("Parent constructor");
//        this (100);

    }

    Parent(int i){
//        super();

        super(i+10);
        System.out.println("Parent constructor i " + i);
    }
    void display() {
        System.out.println("Inside Parent class");
    }
}

class Child extends Parent {
    Child(){
//super(34);
        super.grandpadisplay();
        grandpadisplay();
        System.out.println("Child constructor");

    }
    void display(int a) {
//        super.display();
        System.out.println("Inside Child class: "+a);
    }
}


public class Main {

    public static void main(String[] args) {
//        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
//        String integerListString = integerList.toString();
//        System.out.println("List as String: " + integerListString);
//        System.out.println(integerListString + "nice");
//    pair p1 = new pair(11,12);
//    p1.fun1();
        Parent.schoolname = "hello world";
        System.out.println(Parent.schoolname);

//        Parent h = new Child(); // this is valid. the parent is a subset of child and every member of parent will be initialised by the Child. hence no error. and only the members of Parent which are a part of child will be accessible by the reference Object, even though every Child member is initialised. Parent object cannot access child member.
//        Child t = new Parent(); // this is invalid. because parent does not have knowledge about any extra members present in the child. and they will be left uninitialised. hence error. the reference object will have some members left uninitialised.

    Child c1 = new Child();
    c1.display(4);
c1.grandpadisplay();
        Parent p1 = new Parent(10);
        Child c2 = new Child();
        Child c3 = c1;

        System.out.println(c1==c2);
        System.out.println(c1.equals(c3));
        System.out.println(c1);
//        Parent p2 = new Parent();
//        p1.display();
//        p1.name="John";
//        p2.name="Will";
        p1.schoolname = "ING";
//        System.out.println(p1.name);
//        System.out.println(p2.name);
        System.out.println(p1.schoolname);
        System.out.println(Parent.schoolname);
        Child.schoolname = "test";
        System.out.println("parent school: " + Parent.schoolname);
        Parent.schoolname = "test child";
        System.out.println("child school: " + Child.schoolname);
//        p2.schoolname = "FUK";
//        System.out.println(p1.schoolname);
//        System.out.println(p2.schoolname);

    }

}