package torpedo;

import torpedo.model.GamerVO;
import torpedo.model.MapVO;
import torpedo.service.PlayerTable;
import torpedo.service.ShootTable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
        System.out.println(gamerVO2.getName() +" hajóinak kiválasztása:");
        PlayerTable playerTable2 = new PlayerTable(10, 10);
        MapVO mapVO2 = playerTable2.createTable();
        System.out.println(mapVO2);

        System.out.println("Mindkét játékos pályái készen vannak. Következik a vadászat!");
        ShootTable shootTable = new ShootTable(mapVO2,mapVO1);

            System.out.println(gamerVO1.getName() +" lövése következik");
            MapVO shootTable2 = shootTable.shootValidatorPlayer01();
            System.out.println("Saját tábla: "+mapVO1);
            System.out.println("Ellenfél táblája: "+shootTable2);

            System.out.println(gamerVO2.getName() +" lövése következik");
            MapVO shootTable1 = shootTable.shootValidatorPlayer02();
            System.out.println("Saját tábla: "+mapVO2);
            System.out.println("Ellenfél táblája: "+shootTable1);

        player1.close();
        player2.close();
    }
}

