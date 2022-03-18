public class Generator extends AbstractElement {
    private float generatedCurrent;

    public Generator(String name, float generatedCurrent) {
        super(name);

        this.generatedCurrent = generatedCurrent;
        outputs.setSize(1);
    }

    @Override
    public float eval() {
        System.out.println("Generator " + name + " generates " + generatedCurrent);
        return generatedCurrent;
    }
}
