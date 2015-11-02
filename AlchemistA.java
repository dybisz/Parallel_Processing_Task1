public class AlchemistA extends UniverseWorker {
    @Override
    public void run() {
        try {
            sleepForRandomTime(300,1000);

            /* Increase waiting counter */
            Main.s_numOfWaitingA.acquire();
            Main.c_numOfWaitingA++;
            Main.s_numOfWaitingA.release();

            printInfo("");

            /* Wait for combination */
            Main.s_leadMercury.acquire();
            printInfo("A satisfied.");

        } catch (InterruptedException e) {
        }
    }
}
