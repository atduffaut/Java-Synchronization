import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Astronomer extends Thread implements Crew {
    private final String id;
    private Location location;
    Semaphore lock;
    ReentrantLock shuttleLock;

    public Astronomer(int num, Location loc) {
        this.id = "Astronomer(" + num + ")";
        this.location = loc;
    }

    public void updateLocation(Location loc) {
        this.location = loc;
    }

    public void run() {
        //something like print location name, wait for location change, repeat
        boolean specialLock = false;
        Main.println(this.id + " " + this.location.retrieveName());
        //grab lock from the spaceport
        this.lock = Spaceport.shipSpace;
        this.shuttleLock = Spaceport.shuttleLock;
        try {
            lock.acquire();
            if (shuttleLock.tryLock()) specialLock = true;
            this.location.nextStep(this);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        if (specialLock) {
            Main.println(this.id + " waiting in shuttle and closing the door (NE=" + Spaceport.numAstronomers
                    + ", LE=" + Spaceport.numAstrologers + ", NS=" + 5 + ", LS=" + 0 + ")");
            Main.println(this.id + " On a trip to Mars for 3 Million years.");
            shuttleLock.unlock();
            try {
                sleep(50);
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            Main.println(this.id + " Arrived in Mars.");
            specialLock = false;
        }
        else {
            Main.println(this.id + " " + this.location.retrieveName());
        }

        //send shuttle back home and move to another location with next step
        if (shuttleLock.tryLock()) specialLock = true;

        if (specialLock) {
            Main.println(this.id + " Orders the shuttle to return.");
            shuttleLock.unlock();
            specialLock = false;
        }
    }
}
