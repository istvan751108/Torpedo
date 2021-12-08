package torpedo.service;

import torpedo.model.MapVO;
import java.util.Scanner;

public class PlayerTable {
    boolean actualCoordinateDecision=true;

    private final int numberOfRows;
    private final int numberOfColumns;

    public PlayerTable(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public MapVO createTable() {
        char[][] table = getTable();
        return new MapVO(numberOfRows, numberOfColumns, table);
    }

    private char[][] getTable() {
        char[][] table = new char[numberOfRows][numberOfColumns];
        for (int shipSize = 5; shipSize > 0; shipSize--) {
            System.out.println(shipSize + "-egység hosszú hajó koordinátáinak kiválasztása:");
            createShipPlaces(table, shipSize);
            if (!actualCoordinateDecision){
                shipSize++;
                actualCoordinateDecision=true;
            }
        }
        return table;
    }

    private void createShipPlaces(char[][] table, int shipSize) {
        char shipChar = 'X';

        Scanner coordinateX = new Scanner(System.in);
        System.out.println("Sor koordináta");
        int shipBeginCoordinateX = coordinateX.nextInt();
        Scanner coordinateY = new Scanner(System.in);
        System.out.println("Oszlop koordináta");
        int shipBeginCoordinateY = coordinateY.nextInt();
        Scanner shipDirection = new Scanner(System.in);
        System.out.println("Válaszd ki a hajó elhelyezésének irányát h= vízszintes, minden egyéb=függőleges");
        String shipDirectionOrder = shipDirection.nextLine();

        if (shipDirectionOrder.contains("h")) {
            for (int i=0; i < shipSize; i++) {
                if (table[shipBeginCoordinateX][shipBeginCoordinateY + i] != shipChar) {
                    table[shipBeginCoordinateX][shipBeginCoordinateY + i] = shipChar;
                } else {
                    System.out.println("["+ shipBeginCoordinateX +"]["+ (shipBeginCoordinateY+i)+"] koordinátán már van hajó. Válassz másikat!");
                    actualCoordinateDecision = false;
                }
            }
        } else {
            for (int i=0; i < shipSize; i++) {
                if (table[shipBeginCoordinateX + i][shipBeginCoordinateY] != shipChar) {
                    table[shipBeginCoordinateX + i][shipBeginCoordinateY] = shipChar;
                } else {
                    System.out.println("["+ (shipBeginCoordinateX+i) +"]["+ (shipBeginCoordinateY)+"] koordinátán már van hajó. Válassz másikat!");
                    actualCoordinateDecision = false;
                }
            }
        }
    }
    public static char shootValidator(char[][] table, int shootEnemyX, int shootEnemyY) {
        char newShipChar = 'T';
        char newWaterChar = 'O';

        if (table[shootEnemyX][shootEnemyY] == 'X') {
            table[shootEnemyX][shootEnemyY]= newShipChar;
        } else {
            table[shootEnemyX][shootEnemyY]= newWaterChar;
        }
        return table[shootEnemyX][shootEnemyY];
    }
}
