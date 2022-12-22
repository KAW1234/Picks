package picks.app.picks;


import java.util.Scanner;

public class Create_Scanner {

    private Create_Scanner() {

    }

    Scanner scan = new Scanner(System.in);
    private static Create_Scanner Singleton;

    /**
     * Creates the scanner instance
     *
     * @return
     */
    public static Create_Scanner get_instance() {
        if (Singleton == null) {
            return Singleton = new Create_Scanner();

        }

        return Singleton;

    }

}
