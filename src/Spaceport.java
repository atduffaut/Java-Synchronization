import java.util.concurrent.Semaphore;

public class Spaceport implements Location {
    private Shuttle s;
    private int numAstronomers;
    private int numAstrologers;
    static String analysis;
    static Semaphore shipSpace = new Semaphore(NUM_VOYAGERS);

    public Spaceport(int astronomers, int astrologers) {
        this.numAstrologers = astrologers;
        this.numAstronomers = astronomers;
    }

    public String retrieveName() {
        return "waiting in spaceport.";
    }

    public void nextStep(Crew c) {
        c.updateLocation(new Shuttle());
    }
}
