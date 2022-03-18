public class Timer extends AbstractElement {
    private int callsCounter = 0;
    private int targetCalls;

    public Timer(String name, int targetCalls) {
        super(name);

        this.targetCalls = targetCalls;
        inputs.setSize(1);
        outputs.setSize(1);
    }

    @Override
    public float eval() {
        callsCounter++;

        if(callsCounter >= targetCalls) {
            System.out.println("Timer " + name + " emits");
            callsCounter = 0;
            return inputs.get(0).eval();
        }

        System.out.println("Timer " + name + " sleeps");
        return 0;
    }
}
