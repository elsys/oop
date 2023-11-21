public class Main {
    public static class Baz implements Foo {
        @Override
        public void bar() {
            System.out.println("Baz::bar()");
        }
    }

    public static void main(String[] args) {
        Foo f1 = new Baz();
        f1.bar();

        f1 = new Foo() {
            @Override
            public void bar() {
                System.out.println("Foo::bar()");
            }
        };
        f1.bar();

        MyClass mc = MyClass.foo();





        SingleArgWithResult myVar = new SingleArgWithResult() {
            @Override
            public int process(int arg) {
                return arg * 2;
            }
        };
        Map<Integer, Integer[]> res = NumberProcessor
                .fromArray(arr)
//                .map(myVar)
//                .map(new MyClass())
                .map(new SingleArgWithResult() {
                    ...
                })
                .filter(new SingleArgWithResult() {
                    @Override
                    public int process(int arg) {
                        return arg > 2 ? 1 : 0;
//                        if(arg > 2) {
//                            return 1;
//                        } else {
//                            return 0;
//                        }
                    }
                })
                .groupBy(new SingleArgWithResult() {
                    @Override
                    public int process(int arg) {
                        return arg % 5;
                    }
                });
    }
}
