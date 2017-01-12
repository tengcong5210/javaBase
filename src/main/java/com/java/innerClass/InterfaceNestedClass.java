package com.java.innerClass;

public interface InterfaceNestedClass {
    void helloWord();

    class Test implements InterfaceNestedClass {

        @Override
        public void helloWord() {
            System.out.println("helloWord");
        }

        public static void main(String[] args) {
            Test t = new Test();
            t.helloWord();
        }

    }
}
