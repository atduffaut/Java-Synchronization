public class Astronomer extends Thread implements Crew {
    private String id;
    public Astronomer(int num) {
        this.id = "Astronomer(" + num + ")";
    }

    public void printName() {
        Main.println(this.id + " waiting in spaceport.");
    }

    public void run() {

    }
}
