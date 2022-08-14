package com.bytespaces.HashCode;

import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        ObjectA objectA = new ObjectA("A");
        ObjectA objectAA = new ObjectA("A");
        ObjectA objectAAA = new ObjectA("AA");
        ObjectB objectB = new ObjectB();

        System.out.print("objectA == objectAA : ");
        System.out.println(objectA == objectAA);

        System.out.print("objectA.equals(objectAA) : ");
        System.out.println(objectA.equals(objectAA));

        System.out.print("objectA.equals(objectB) : ");
        System.out.println(objectA.equals(objectB));

        System.out.print("objectA.hashCode() : ");
        System.out.println(objectA.hashCode());

        System.out.print("objectAA.hashCode() : ");
        System.out.println(objectAA.hashCode());

        System.out.print("objectAAA.hashCode() : ");
        System.out.println(objectAAA.hashCode());

        System.out.print("objectB.hashCode() : ");
        System.out.println(objectB.hashCode());

        //查看HashSet进一步加深印象
        HashSet<String> hashSet = new HashSet<>();

    }
}
