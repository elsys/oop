public class Main {
//        gen1 ==> lamp1
    private static void example1() throws Exception {
        Generator gen1 = new Generator("gen1", 1.5f);
        Lamp lamp1 = new Lamp("lamp1", 0.6f);

        gen1.setOutput(0, lamp1);
        lamp1.setInput(0, gen1);

        lamp1.eval();
    }

//                       /==> lamp1
//        gen1 ==> split1
//                       \==> lamp2
    private static void example2() throws Exception {
        Generator gen1 = new Generator("gen1", 1.5f);
        Splitter split1 = new Splitter("split1", 2);
        Lamp lamp1 = new Lamp("lamp1", 0.6f);
        Lamp lamp2 = new Lamp("lamp2", 0.8f);

        gen1.setOutput(0, split1);
        split1.setOutput(0, lamp1);
        split1.setOutput(1, lamp2);

        split1.setInput(0, gen1);
        lamp1.setInput(0, split1);
        lamp2.setInput(0, split1);

        lamp1.eval();
        lamp2.eval();
    }

//        gen1 ==> timer1 ==> lamp1
    private static void example3() throws Exception {
        Generator gen1 = new Generator("gen1", 1.5f);
        Timer timer1 = new Timer("timer1", 3);
        Lamp lamp1 = new Lamp("lamp1", 0.6f);

        gen1.setOutput(0, timer1);
        timer1.setOutput(0, lamp1);

        timer1.setInput(0, gen1);
        lamp1.setInput(0, timer1);

        lamp1.eval();
        lamp1.eval();
        lamp1.eval();
        lamp1.eval();
    }

    private static void example4() throws Exception {
//        Create elements
        Generator g1 = new Generator("gen1", 1.2f);
        Generator g2 = new Generator("gen2", 0.2f);
        Generator g3 = new Generator("gen3", 1.2f);
        Generator g4 = new Generator("gen4", 1.2f);
        Generator g5 = new Generator("gen5", 1.2f);

        Splitter s1 = new Splitter("split1", 2);

        Timer t1 = new Timer("timer1", 2);

        Multiplexer m1 = new Multiplexer("mux1", 2);

        Lamp l1 = new Lamp("lamp1", 0.6f);

//        Connect outputs
        g1.setOutput(0, m1);
        g2.setOutput(0, s1);
        g3.setOutput(0, m1);
        g4.setOutput(0, m1);
        g5.setOutput(0, t1);

        s1.setOutput(0, m1);
        s1.setOutput(1, m1);

        t1.setOutput(0, m1);

        m1.setOutput(0, l1);

//        Connect inputs
        l1.setInput(0, m1);

        m1.setInput(0, s1);
        m1.setInput(1, g1);

        m1.setInput(2, s1);
        m1.setInput(3, g3);
        m1.setInput(4, g4);
        m1.setInput(5, t1);

        s1.setInput(0, g2);

        t1.setInput(0, g5);

        l1.eval();
        l1.eval();
        l1.eval();
    }

    public static void main(String[] args) throws Exception {
        example1();
//        example2();
//        example3();
//        example4();
    }
}
