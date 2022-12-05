import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Spaceport implements Location {
    private Shuttle s;
    static int numAstronomers;
    static int numAstrologers;
    static Semaphore shipSpace = new Semaphore(NUM_VOYAGERS);
    static ReentrantLock shuttleLock = new ReentrantLock();
    Shuttle shuttle;

    public Spaceport(int astronomers, int astrologers) {
        numAstrologers = astrologers;
        numAstronomers = astronomers;
        shuttle = new Shuttle(5, 0);
    }

    public String retrieveName() {
        return "waiting in spaceport.";
    }

    public void nextStep(Crew c) {
        c.updateLocation(shuttle);
        if (!shuttle.isAlive()) {
            shuttle.start();
        }
    }
}
