import java.util.concurrent.locks.ReentrantLock;

public class Shuttle extends Thread implements Location {
    //shuttle is going to hold 5 threads, as well as be a thread on its own
    ReentrantLock lock;
    private int numAstronomers;
    private int numAstrologers;
    public Shuttle(int astronomers, int astrologers) {
        //how do we initialize a shuttle with all the threads we need?
        this.numAstronomers = astronomers;
        this.numAstrologers = astrologers;
    }

    public String retrieveName() {
        return "waiting in shuttle.";
    }

    public void nextStep(Crew c) {
        //send the crew into quarantine, which means releasing all their locks

    }

    public void run() {
        //acquire the shuttle lock, sleep for some time, print the needed messages
        this.lock = Spaceport.shuttleLock;
        lock.lock();
        try {
            sleep(50);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        } finally {
            lock.unlock();
        }
    }
}
