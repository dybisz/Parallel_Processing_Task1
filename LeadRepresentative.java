public class LeadRepresentative extends Representative {
    @Override
    public void run() {
        try {
            sleepForRandomTime(200, 500);
            Main.s_market.acquire();

            checkLeadSupplies();
            printInfo("");

            /* To somehow prevent starvation */
            if (Main.c_lastSatisfied != 'C') {
                checkLeadMercurySulfurCombination();
            }
            checkLeadMercuryCombination();
            checkMercurySulfurCombination();
            checkLeadMercurySulfurCombination();

            Main.s_market.release();
        } catch (InterruptedException e) {
        }
    }
}
