public abstract class Representative extends UniverseWorker {

    protected void checkLeadSupplies() {
        if (Main.c_lead < 2) {
            Main.c_lead++;
        }
    }

    protected void checkMercurySupplies() {
        if (Main.c_mercury < 2) {
            Main.c_mercury++;
        }
    }

    protected void checkSulfurSupplies() {
        if (Main.c_sulfur < 2) {
            Main.c_sulfur++;
        }
    }

    protected void checkLeadMercuryCombination() throws InterruptedException {
        if (Main.c_lead > 0 && Main.c_mercury > 0) {

            Main.s_numOfWaitingA.acquire();

            if (Main.c_numOfWaitingA > 0) {
                Main.c_numOfWaitingA--;
                Main.c_lead--;
                Main.c_mercury--;
                Main.c_lastSatisfied = 'A';
                Main.s_leadMercury.release();
            }

            Main.s_numOfWaitingA.release();
        }
    }

    protected void checkMercurySulfurCombination() throws InterruptedException {
        if (Main.c_mercury > 0 && Main.c_sulfur > 0) {

            Main.s_numOfWaitingB.acquire();

            if (Main.c_numOfWaitingB > 0) {
                Main.c_numOfWaitingB--;
                Main.c_mercury--;
                Main.c_sulfur--;
                Main.c_lastSatisfied = 'B';
                Main.s_mercurySulfur.release();
            }

            Main.s_numOfWaitingB.release();
        }
    }


    protected void checkLeadMercurySulfurCombination() throws InterruptedException {
        if (Main.c_lead > 0 && Main.c_mercury > 0 && Main.c_sulfur > 0) {

            Main.s_numOfWaitingC.acquire();

            if (Main.c_numOfWaitingC > 0) {
                Main.c_numOfWaitingC--;
                Main.c_lead--;
                Main.c_mercury--;
                Main.c_sulfur--;
                Main.c_lastSatisfied = 'C';
                Main.s_leadMercurySulfur.release();
            }

            Main.s_numOfWaitingC.release();
        }
    }

}
