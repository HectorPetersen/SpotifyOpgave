
import java.util.ArrayList;
import java.util.Scanner;

public class SongTest {
    public static ArrayList<Song> songList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {
        System.out.println("Velkommen til Spotify!");
        System.out.println("indtast dit navn: ");
        String name = scanner.nextLine();

        //System.out.print("Er du Free eller Premium bruger? ");
        //String userType = scanner.nextLine();
        boolean running = true;
        while (running) {
            System.out.println("Vælg en mulighed:");
            System.out.println("1. Tilføj ny sang");
            System.out.println("2. Fjern sang");
            System.out.println("3. Vis tilføjet sange");
            System.out.println("4. Søg efter sang");
            System.out.println("5. Rediger en sang");
            System.out.println("6. Afslut programmet");
            System.out.print("Valg: ");

            int valg = scanner.nextInt();

            switch (valg) {
                case 1 -> addSong();
                case 2 -> removeSong();
                case 3 -> showSongs();
                case 4 -> searchSong();
                case 5 -> editSong();
                case 6 -> running = false;
            }

        }
        }
    }
