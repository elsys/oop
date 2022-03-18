public class Lamp extends AbstractElement {
    private float requiredCurrent;

    public Lamp(String name, float requiredCurrent) {
        super(name);

        this.requiredCurrent = requiredCurrent;
        inputs.setSize(1);
    }

    @Override
    public float eval() {
        float inputCurrent = 0f;

        // All elements should have a check if their input(s) is null (i.e. not set, not connected)
        // That's omitted in other classes for brevity
        AbstractElement input = inputs.get(0);
        if(input != null)
            inputCurrent = input.eval();

        if(inputCurrent >= requiredCurrent)
            System.out.println("Lamp " + name + " lights up");
        else
            System.out.println("Lamp " + name + " doesn't have power");

        return 0;
    }
}
