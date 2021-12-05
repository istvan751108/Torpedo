package torpedo;

import torpedo.model.GamerVO;
import torpedo.service.PlayerTable;
import torpedo.service.ShootTable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import static java.util.Arrays.*;

public class Main {

    public static void main(String[] args) {
        Scanner player1 = new Scanner(System.in);
        System.out.println("Adja meg az 1. játékos nevét:");
        GamerVO gamerVO1 = new GamerVO(player1.nextLine());
        System.out.println("Kellemes szórakozást kívánok neked," + gamerVO1.getName() + "!");

        System.out.println("Az 1. játékos hajóinak kiválasztása:");
        PlayerTable playerTable1 = new PlayerTable(10, 10);
        System.out.println(playerTable1.createTable());
        Scanner player2 = new Scanner(System.in);

        System.out.println("Adja meg a 2. játékos nevét:");
        GamerVO gamerVO2 = new GamerVO(player2.nextLine());
        System.out.println("Kellemes szórakozást kívánok neked," + gamerVO2.getName() + "!");
        System.out.println("A 2. játékos hajóinak kiválasztása:");
        PlayerTable playerTable2 = new PlayerTable(10, 10);
        System.out.println(playerTable2.createTable());
        System.out.println("A pályák készen vannak. Következik a vadászat!");

        ShootTable shootTable1 = new ShootTable(10, 10);
        System.out.println(shootTable1.createNewShooterTable());

        player1.close();
        player2.close();
    }
}

