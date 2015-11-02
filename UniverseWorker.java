import java.util.Random;

public class UniverseWorker extends Thread {

    protected void sleepForRandomTime(int min, int max) {
        Random rnd = new Random();
        try {
            Thread.sleep(rnd.nextInt(max) + min);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void printInfo(String info) {
        if (Main.DEBUG) {
            System.out.println("l: " + Main.c_lead + " | m: "
                    + Main.c_mercury + " | s: " + Main.c_sulfur
                    + " | A: " + Main.c_numOfWaitingA
                    + " | B: " + Main.c_numOfWaitingB
                    + " | C: " + Main.c_numOfWaitingC
                    + " | LAST: " + Main.c_lastSatisfied
                    + " " + info);
        }
    }
}
