package common;

public class MyClass {

    private class A{
        private int i=1;
        private B b = new B();
        private int j = b.j;

        public void printJ(){
            System.out.println(j);
        }

    }

    private class B{
        private int j=2;
    }

    public static void main(String[] args){
        MyClass myClass = new MyClass();
        A a = myClass.new A();
        a.printJ();
        System.out.println(a.i);
    }
}
