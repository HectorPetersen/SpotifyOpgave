import java.util.Scanner;
import java.util.ArrayList;

public class SongTest {

    protected static ArrayList<Song> songs = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Velkommen til det hjemmelavede Spotify!");
        User user = loginFlow();

        boolean running = true;
        while (running) {
            printMenu(user);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addSong();
                case "2" -> removeSong();
                case "3" -> showSongs();
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
            System.out.println("7. Download sange (Premium funktion)");
        }
        System.out.print("Dit valg: ");
    }

    private static void addSong() {
        System.out.print("Hvilken sang vil du gerne tilføje?: ");
        String title = scanner.nextLine();
       try {
           System.out.print("Hvilken genre har din sang? (Rock/Pop/Jazz/Country): ");
           String genre = scanner.nextLine();
           songs.add(new Song(title, Genre.valueOf(genre.toUpperCase())));
           System.out.println("Sangen '" + title + "' er blevet tilføjet.");
       } catch (IllegalArgumentException e) {
           System.out.println("Denne genre findes ikke");
        }


    }

    private static void removeSong() {
        System.out.print("Hvilken sang vil du gerne fjerne?: ");
        String title = scanner.nextLine();
        Song song = findByTitle(title);
        if (song != null) {
            songs.remove(song);
            System.out.println("Sangen '" + title + "' er blevet fjernet.");
        } else {
            System.out.println("Sangen '" + title + "' blev ikke fundet.");
        }
    }

    private static void searchSong() {
        System.out.println("Hvilken sang vil du søge efter?");
        String choice = scanner.nextLine();
        System.out.println(findByTitle(choice));
    }

    private static void editSong() {

    }

    private static void showAd() {
        System.out.println("---- REKLAME ----");
        System.out.println("Opgrader til Premium for reklamefri musik og download!");
        System.out.println("-----------------");
    }

    private static Song findByTitle(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }
    private static void showSongs() {
        if (songs.isEmpty()) {
            System.out.println("ingen sange i listen.");
        } else {
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }
}
