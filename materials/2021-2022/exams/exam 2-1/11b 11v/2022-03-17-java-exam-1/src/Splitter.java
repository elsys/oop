public class Splitter extends AbstractElement {
    private int outputCount = 0;

    public Splitter(String name, int outputCount) {
        super(name);

        this.outputCount = outputCount;
        outputs.setSize(outputCount);
        inputs.setSize(1);
    }

    @Override
    public float eval() {
        System.out.println("Splitter " + name + " splits " + outputCount + " ways");
        float inputCurrent = inputs.get(0).eval();
        return inputCurrent / outputCount;
    }
}
