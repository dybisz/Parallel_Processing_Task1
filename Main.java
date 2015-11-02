import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final boolean DEBUG = true;
    public static final int MAX_EXECUTE_TIME_IN_SEC = 10;
    public static ExecutorService executor = Executors.newFixedThreadPool(100);

    public static int c_numOfWaitingA = 0;
    public static int c_numOfWaitingB = 0;
    public static int c_numOfWaitingC = 0;

    public static Semaphore s_numOfWaitingA = new Semaphore(1);
    public static Semaphore s_numOfWaitingB = new Semaphore(1);
    public static Semaphore s_numOfWaitingC = new Semaphore(1);

    public static Semaphore s_leadMercury = new Semaphore(0);
    public static Semaphore s_mercurySulfur = new Semaphore(0);
    public static Semaphore s_leadMercurySulfur = new Semaphore(0);

    public static Semaphore s_market = new Semaphore(1);
    public static int c_lead = 0;
    public static int c_mercury = 0;
    public static int c_sulfur = 0;
    public static char c_lastSatisfied = 'A';

    public static void main(String[] args) {
        produceAlchemists();
        produceRepresentatives();
        shoutDownAllAfterInterval();
    }

    private static void produceAlchemists() {
        for (int i = 0; i < 20; i++) {
            Thread alchemistA = new AlchemistA();
            Thread alchemistB = new AlchemistB();
            Thread alchemistC = new AlchemistC();
            executor.execute(alchemistA);
            executor.execute(alchemistB);
            executor.execute(alchemistC);
        }
    }

    private static void produceRepresentatives() {
        for (int i = 0; i < 50; i++) {
            Thread leadRepresentative = new LeadRepresentative();
            Thread mercuryRepresentative = new MercuryRepresentative();
            Thread sulfurRepresentative = new SulfurRepresentative();

            executor.execute(leadRepresentative);
            executor.execute(mercuryRepresentative);
            executor.execute(sulfurRepresentative);
        }
    }

    private static void shoutDownAllAfterInterval() {
        try {
            if (executor.awaitTermination(MAX_EXECUTE_TIME_IN_SEC, TimeUnit.SECONDS)) {
                System.out.println("\nClean exit.");
            } else {
                System.out.println("\nTime out. Forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
