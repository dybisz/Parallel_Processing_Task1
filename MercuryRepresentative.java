public class MercuryRepresentative extends Representative {
    @Override
    public void run() {
        try {
            sleepForRandomTime(200, 500);
            Main.s_market.acquire();

            checkMercurySupplies();
            printInfo("");

            /* To somehow prevent starvation */
            if (Main.c_lastSatisfied != 'C') {
                checkLeadMercurySulfurCombination();
            }
            checkMercurySulfurCombination();
            checkLeadMercuryCombination();
            checkLeadMercurySulfurCombination();

            Main.s_market.release();
        } catch (InterruptedException e) {
        }
    }

}
