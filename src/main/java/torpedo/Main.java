package torpedo;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import torpedo.model.GamerVO;
import torpedo.model.MapVO;
import torpedo.service.CheckerTable;
import torpedo.service.EndChecker;
import torpedo.service.PlayerTable;
import torpedo.service.ShootTable;

/**
 * This is my first Torpedo game.
 *
 * @author István Szabó
 * @version 1.8
 */

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    /**
     * This is the main method. Some kind of handy description goes here.
     *
     * @param args The command line arguments.
     */

    public static void main(String[] args) {
        LOGGER.info("A játék elkezdődött");
        Scanner player1 = new Scanner(System.in);
        System.out.println("Adja meg az 1. játékos nevét:");
        GamerVO gamerVO1 = new GamerVO(player1.nextLine());
        System.out.println("Kellemes szórakozást kívánok neked," + gamerVO1.getName() + "!");

        System.out.println(gamerVO1.getName() + " hajóinak kiválasztása:");
        PlayerTable playerTable1 = new PlayerTable(10, 10);
        MapVO mapVO1 = playerTable1.createTable();
        System.out.println(mapVO1);

        Scanner player2 = new Scanner(System.in);
        System.out.println("Adja meg a 2. játékos nevét:");
        GamerVO gamerVO2 = new GamerVO(player2.nextLine());
        System.out.println("Kellemes szórakozást kívánok neked," + gamerVO2.getName() + "!");
        System.out.println(gamerVO2.getName() + " hajóinak kiválasztása:");
        PlayerTable playerTable2 = new PlayerTable(10, 10);
        MapVO mapVO2 = playerTable2.createTable();
        System.out.println(mapVO2);
        System.out.println("Mindkét játékos pályái készen vannak. Következik a vadászat!");
        boolean end = false;

        do {
            ShootTable shootTable = new ShootTable(mapVO2, mapVO1);
            System.out.println(gamerVO1.getName() + " lövése következik");
            MapVO shootTable2 = shootTable.shootValidatorPlayer01();
            System.out.println(gamerVO2.getName() + " lövése következik");
            MapVO shootTable1 = shootTable.shootValidatorPlayer02();
            CheckerTable checkerTable = new CheckerTable(shootTable2, shootTable1);
            MapVO checkerTable2 = checkerTable.checkerTablePlayer01();
            MapVO checkerTable1 = checkerTable.checkerTablePlayer02();
            System.out.println(gamerVO1.getName() + " saját táblája: " + shootTable1);
            System.out.println(gamerVO1.getName() + " ellenfelének táblája: " + checkerTable2);

            System.out.println(gamerVO2.getName() + " saját táblája: " + shootTable2);
            System.out.println(gamerVO2.getName() + " ellenfelének táblája: " + checkerTable1);
            mapVO1 = shootTable1;
            mapVO2 = shootTable2;
            EndChecker endChecker = new EndChecker(shootTable2, shootTable1);
            boolean endPlayer01 = endChecker.endCheckerPlayer01();
            boolean endPlayer02 = endChecker.endCheckerPlayer02();
            if ((endPlayer01) || (endPlayer02)) {
                end = true;
            }
        } while (!end);

        LOGGER.info("Vége a játéknak!");
        player1.close();
        player2.close();
    }
}

