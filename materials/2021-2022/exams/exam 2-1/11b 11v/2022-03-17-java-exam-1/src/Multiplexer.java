public class Multiplexer extends AbstractElement {
    private int selectionCount;

    public Multiplexer(String name, int selectionCount) {
        super(name);
        this.selectionCount = selectionCount;
        inputs.setSize((int) (selectionCount + Math.pow(2, selectionCount)));
        outputs.setSize(1);
    }

    @Override
    public float eval() {
        int selectedInput = 0;

        for(int i = 0; i < selectionCount; i++) {
            selectedInput <<= 1;
            selectedInput += inputs.get(selectionCount + i).eval() > 0.5 ? 1 : 0;
        }

        System.out.println("Multiplexer " + name + " reads from " + selectedInput);

        return inputs.get(selectedInput + selectionCount).eval();
    }
}
