public class Examples implements Runnable {
    @Override
    public void run() {
//        while(true) {
//            try {
//                System.out.println("Hello");
////            try {
//                Thread.sleep(500);
////            } catch (InterruptedException e) {
////                System.out.printf("Interrupted");
////                return;
////            }
//                if(Thread.interrupted())
//                    throw new InterruptedException();
//
//            } catch (InterruptedException e) {
//                System.out.printf("Interrupted");
//                return;
//            }
//            }
//
        while(true) {
            System.out.println("Hello");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }

        while(true) {
            System.out.println("Goodbye");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }

    }
}
