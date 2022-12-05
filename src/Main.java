public class Main {
    public static int DEFAULT_TRAVELERS = 100;
    public static void print(String str) {
        System.out.print(str);
    }
    public static void println(String str) {
        System.out.println(str);
    }
    public static void main(String[] args) {
        int numTravelers = DEFAULT_TRAVELERS;
        int numAstronomers = 0, numAstrologers = 0;

        switch(args.length) {
            case 1:
                numTravelers = Integer.parseInt(args[0]);
            case 0:
                numAstronomers = (int) (1 + Math.random() * numTravelers);
                numAstrologers = numTravelers - numAstronomers;
                break;
            case 2:
                numAstronomers = Integer.parseInt(args[0]);
                numAstrologers = Integer.parseInt(args[1]);
                break;
            default:
                println("Too many arguments");
                break;
        }

        println("Number of astronomers: " + numAstronomers + ". Number of astrologers: " + numAstrologers);

        Spaceport s = new Spaceport(numAstronomers, numAstrologers);
    }
}