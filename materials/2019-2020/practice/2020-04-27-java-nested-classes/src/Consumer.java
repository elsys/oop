public class Consumer {
    private static int instanceCount = 0;
    private int foo = 0;
    private int instanceNumber;

    Consumer(FooSource s) {
        instanceNumber = Consumer.instanceCount++;

        s.subscribe(new Source.EventHandler() {
            @Override
            public void handle(Source.Event e) {
                foo += ((FooSource.FooEvent)e).payload;
                System.out.println("[Consumer "+ instanceNumber + "] foo = " + foo);
            }
        });
    }
}
