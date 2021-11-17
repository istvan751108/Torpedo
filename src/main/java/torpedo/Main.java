package torpedo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a játékos nevét:");
        GamerVO gamerVO = new GamerVO(scanner.nextLine());
        System.out.println("Kellemes szórakozást kívánok neked," + gamerVO.getNev() + "!");
    }
}

