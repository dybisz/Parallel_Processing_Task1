/**
 * Created by dybisz on 02/11/2015.
 */
public class AlchemistB extends UniverseWorker {
    @Override
    public void run() {
        try {
            sleepForRandomTime(300,1000);

            /* Increase waiting counter */
            Main.s_numOfWaitingB.acquire();
            Main.c_numOfWaitingB++;
            Main.s_numOfWaitingB.release();

            printInfo("");

            /* Wait for combination */
            Main.s_mercurySulfur.acquire();
            printInfo("B satisfied");

        } catch (InterruptedException e) {
        }
    }
}
