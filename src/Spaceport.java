public class Spaceport implements Location {
    private Shuttle s;
    private int numAstronomers;
    private int numAstrologers;
    private Crew crew[];

    public Spaceport(int astronomers, int astrologers) {
        this.numAstrologers = astrologers;
        this.numAstronomers = astronomers;
        this.crew = new Crew[numAstrologers + numAstronomers];
        for (int i = 1; i < astronomers + 1; i++) {
            this.crew[i - 1] = new Astronomer(i);
        }
        for (int i = astronomers + 1; i < astrologers + astronomers + 1; i++) {
            this.crew[i - 1] = new Astrologer(i);
        }
        for (Crew member : this.crew) {
            member.printName();
        }
    }

    public void nextStep() {

    }
}
