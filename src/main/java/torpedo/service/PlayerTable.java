package torpedo.service;

import java.util.Scanner;

import torpedo.model.MapVO;

/**
 * This Class makes players' boards.
 *
 * @author István Szabó
 */
public class PlayerTable {
    boolean actualCoordinateDecision = true;

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

    /**
     * This method puts the ships on the battlefield.
     *
     * @return  the player's board with his ships.
     */
    public char[][] getTable() {
        char[][] table = new char[numberOfRows][numberOfColumns];
        for (int shipSize = 5; shipSize > 0; shipSize--) {
            System.out.println(shipSize + "-egység hosszú hajó koordinátáinak kiválasztása:");
            createShipPlaces(table, shipSize);
            if (!actualCoordinateDecision) {
                shipSize++;
                actualCoordinateDecision = true;
            }
        }
        return table;
    }

    private void createShipPlaces(char[][] table, int shipSize) {
        char shipChar = 'X';

        Scanner coordinateX = new Scanner(System.in);
        System.out.println("Sor koordináta");
        int shipBeginPointX = coordinateX.nextInt();
        Scanner coordinateY = new Scanner(System.in);
        System.out.println("Oszlop koordináta");
        int shipBeginPointY = coordinateY.nextInt();
        Scanner shipDirection = new Scanner(System.in);
        System.out.println("Válaszd ki a hajó elhelyezésének irányát h= vízszintes, minden egyéb=függőleges");
        String shipDirectionOrder = shipDirection.nextLine();

        if (shipDirectionOrder.contains("h")) {
            for (int i = 0; i < shipSize; i++) {
                if (table[shipBeginPointX][shipBeginPointY + i] != shipChar) {
                    table[shipBeginPointX][shipBeginPointY + i] = shipChar;
                } else {
                    System.out.println("[" + shipBeginPointX + "][" + (shipBeginPointY + i) + "] ponton már van hajó. Válassz másikat!");
                    actualCoordinateDecision = false;
                }
            }
        } else {
            for (int i = 0; i < shipSize; i++) {
                if (table[shipBeginPointX + i][shipBeginPointY] != shipChar) {
                    table[shipBeginPointX + i][shipBeginPointY] = shipChar;
                } else {
                    System.out.println("[" + (shipBeginPointX + i) + "][" + (shipBeginPointY) + "] ponton már van hajó. Válassz másikat!");
                    actualCoordinateDecision = false;
                }
            }
        }
    }
}
