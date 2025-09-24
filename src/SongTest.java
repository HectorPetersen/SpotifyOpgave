import java.util.Scanner;
import java.util.ArrayList;

public class SongTest {

    ArrayList<Song> songs = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Velkommen til dit hjemmelavede Spotify!");
        User user = loginFlow();

        boolean running = true;
        while (running) {
            printMenu(user);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addSong();
                case "2" -> removeSong();
                case "3" -> showAll();
                case "4" -> searchSong();
                case "5" -> editSong();
                case "6" -> running = false;
                default -> System.out.println("Ugyldigt valg, prøv igen.");
            }

            if (running && !user.isPremium()) showAd();
        }
        System.out.println("Farvel!");
    }

    private static User loginFlow() {
        System.out.print("Indtast brugernavn: ");
        String name = scanner.nextLine();
        System.out.print("Er du premium? (ja/nej): ");
        boolean isPremium = scanner.nextLine().trim().toLowerCase().startsWith("j");
        System.out.println(isPremium ? "Premium aktiveret. Ingen reklamer."
                : "Free-konto. Reklamer vises.");
        return new User(name, isPremium);
    }

    private static void printMenu(User user) {
        System.out.println();
        System.out.println("Vælg en mulighed:");
        System.out.println("1. Tilføj ny sang");
        System.out.println("2. Fjern en sang");
        System.out.println("3. Vis alle sange");
        System.out.println("4. Søg efter en sang");
        System.out.println("5. Rediger en sang");
        System.out.println("6. Afslut programmet");
        if (user.isPremium()) {
            System.out.println("(Premium: download er tilgængelig i fremtidig version)");
        }
        System.out.print("Dit valg: ");
    }
}
