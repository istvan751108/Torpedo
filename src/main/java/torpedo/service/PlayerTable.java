package torpedo.service;

import torpedo.model.MapVO;

import java.util.Scanner;

public class PlayerTable {
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
            for (int j = 0; j < shipSize; j++) {
                table[shipBeginCoordinateX][shipBeginCoordinateY + j] = shipChar;
            }
        } else {
            for (int j = 0; j < shipSize; j++){
                table[shipBeginCoordinateX + j][shipBeginCoordinateY] = shipChar;
            }

        }
    }
}
