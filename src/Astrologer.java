public class Astrologer extends Thread implements Crew {
    private String id;
    public Astrologer(int num) {
        this.id = "Astrologer(" + num + ")";
    }

    public void printName() {
        Main.println(this.id + " waiting in spaceport.");
    }

    public void run() {

    }
}
