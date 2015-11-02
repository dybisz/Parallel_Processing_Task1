/**
 * Created by dybisz on 02/11/2015.
 */
public class AlchemistC extends UniverseWorker {
    @Override
    public void run() {
        try {
            sleepForRandomTime(300,1000);

            /* Increase waiting counter */
            Main.s_numOfWaitingC.acquire();
            Main.c_numOfWaitingC++;
            Main.s_numOfWaitingC.release();

            printInfo("");

            /* Wait for combination */
            Main.s_leadMercurySulfur.acquire();
            printInfo("C satisfied");

        } catch (InterruptedException e) {
        }
    }
}
