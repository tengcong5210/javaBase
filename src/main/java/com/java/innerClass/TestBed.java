package com.java.innerClass;

public class TestBed {
    public void f() {
        System.out.println("f()");
    }

    public static class Tester {

        public static void main(String[] args) {
            TestBed tb = new TestBed();
            tb.f();
        }
    }
}
