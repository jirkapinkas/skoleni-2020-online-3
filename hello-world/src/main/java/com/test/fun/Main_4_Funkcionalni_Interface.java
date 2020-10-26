package com.test.fun;

// interface s PRAVE JEDNOU ABSTRAKTNI METODOU JE TZV. Funkcionalni interface
// takovy interface se da alternativne zapsat jako lambda vyraz
@FunctionalInterface
interface I {
    void test();

    default void test2() { }
    static void test3() { }
    // TOHLE NENI ABSTRAKTNI METODA!!!
    // JEJI UVEDENI V INTERFACE MA VYZNAM POUZE KVULI DOKUMENTACI!!!
    String toString();
}

public class Main_4_Funkcionalni_Interface {

    public static void main(String[] args) {

    }

}
