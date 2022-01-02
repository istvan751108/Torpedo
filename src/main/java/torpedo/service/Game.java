package torpedo.service;

import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import torpedo.model.GamerVO;
import torpedo.model.MapVO;
import torpedo.persistence.impl.JdbcPlayerRepository;

/**
 * This Class starts the game.
 *
 * @author István Szabó
 */
public class Game {
    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);
    int starterPoint = 10;

    void game() throws SQLException {
        LOGGER.info("A játék elkezdődött");
        Scanner player1 = new Scanner(System.in);
        System.out.println("Adja meg az 1. játékos nevét:");
        String input1 = null;
        input1 = player1.nextLine();
        GamerVO gamerVO1 = new GamerVO(input1);
        System.out.println("Kellemes szórakozást kívánok neked," + input1 + "!");
        gamerVO1.setPoint(starterPoint);
        JdbcPlayerRepository jdbcPlayerRepository1;
        jdbcPlayerRepository1 = new JdbcPlayerRepository(gamerVO1);
        jdbcPlayerRepository1.addPlayer(gamerVO1);
        System.out.println(gamerVO1.getName() + " hajóinak kiválasztása:");
        PlayerTable playerTable1 = new PlayerTable(10, 10);
        MapVO mapVO1 = playerTable1.createTable();
        System.out.println(mapVO1);

        Scanner player2 = new Scanner(System.in);
        System.out.println("Adja meg a 2. játékos nevét:");
        String input2 = null;
        input2 = player2.nextLine();
        GamerVO gamerVO2 = new GamerVO(input2);
        System.out.println("Kellemes szórakozást kívánok neked," + input2 + "!");
        gamerVO2.setPoint(starterPoint);
        JdbcPlayerRepository jdbcPlayerRepository2;
        jdbcPlayerRepository2 = new JdbcPlayerRepository(gamerVO2);
        jdbcPlayerRepository2.addPlayer(gamerVO2);
        System.out.println(gamerVO2.getName() + " hajóinak kiválasztása:");
        PlayerTable playerTable2 = new PlayerTable(10, 10);
        MapVO mapVO2 = playerTable2.createTable();
        System.out.println(mapVO2);
        System.out.println("Mindkét játékos pályái készen vannak. Következik a vadászat!");
        boolean end = false;
        int shootPoint = starterPoint;
        do {
            shootPoint++;
            System.out.println(gamerVO1.getName() + " lövése következik");
            gamerVO1.setPoint(shootPoint);
            gamerVO1.setNev(input1);
            jdbcPlayerRepository1.modPlayer(gamerVO1);
            gamerVO2.setPoint(shootPoint);
            gamerVO2.setNev(input2);
            jdbcPlayerRepository2.modPlayer(gamerVO2);
            ShootTable shootTable = new ShootTable(mapVO2, mapVO1);
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
            if (endPlayer01) {
                gamerVO1.setPoint(shootPoint + 100);
                gamerVO1.setNev(input1);
                jdbcPlayerRepository1.modPlayer(gamerVO1);
            }
            if (endPlayer02) {
                gamerVO2.setPoint(shootPoint + 100);
                gamerVO2.setNev(input2);
                jdbcPlayerRepository2.modPlayer(gamerVO2);
            }
            if ((endPlayer01) || (endPlayer02)) {
                end = true;
            }
        } while (!end);

        LOGGER.info("Vége a játéknak!");
        jdbcPlayerRepository1.readPlayer();
        player1.close();
        player2.close();
    }
}
