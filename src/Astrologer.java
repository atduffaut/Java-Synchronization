import java.util.concurrent.Semaphore;

public class Astrologer extends Thread implements Crew {
    private final String id;
    private Location location;
    Semaphore lock;
    public Astrologer(int num, Location loc) {
        this.id = "Astrologer(" + num + ")";
        this.location = loc;
    }

    public void updateLocation(Location loc) {
        this.location = loc;
    }

    public void run() {
        //something like print location name, wait for location change, repeat
        Main.println(this.id + " " + this.location.retrieveName());
        //grab lock from the spaceport
        this.lock = Spaceport.shipSpace;
        try {
            lock.acquire();
            this.location.nextStep(this);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        Main.println(this.id + " " + this.location.retrieveName());
    }
}
