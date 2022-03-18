import java.util.Vector;

public abstract class AbstractElement {
    protected String name;
    protected Vector<AbstractElement> inputs = new Vector<>();
    protected Vector<AbstractElement> outputs = new Vector<>();

    public AbstractElement(String name) {
        this.name = name;
    }

    public void setInput(int index, AbstractElement e) throws Exception {
        if(index > inputs.size()) throw new Exception("Invalid index");

        inputs.set(index, e);
    }

    public void setOutput(int index, AbstractElement e) throws Exception {
        if(index > outputs.size()) throw new Exception("Invalid index");

        outputs.set(index, e);
    }

    public abstract float eval();
}
