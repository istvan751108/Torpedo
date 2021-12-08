package torpedo.service;

import torpedo.model.MapVO;
import torpedo.service.PlayerTable;
import java.util.Scanner;

public class ShootTable {

        boolean actualCoordinateDecision=true;

        private final int numberOfRows;
        private final int numberOfColumns;

        public ShootTable(int numberOfRows, int numberOfColumns) {
            this.numberOfRows = numberOfRows;
            this.numberOfColumns = numberOfColumns;
        }

        public MapVO createNewShooterTable() {
            char[][] table = getTable();
            return new MapVO(numberOfRows, numberOfColumns, table);
        }

        private char[][] getTable() {
            char[][] table = new char[numberOfRows][numberOfColumns];
            System.out.println("Add meg a cél koordinátákat!");
            targetShipPlaces(table);
            return table;
        }

        private void targetShipPlaces(char[][] table) {
            char targetShipChar;
            int scoreActual = 1000;
            Scanner shootCoordinateX = new Scanner(System.in);
            System.out.println("Sor koordináta");
            int targetCoordinateX = shootCoordinateX.nextInt();
            Scanner shootCoordinateY = new Scanner(System.in);
            System.out.println("Oszlop koordináta");
            int targetCoordinateY = shootCoordinateY.nextInt();
            targetShipChar = PlayerTable.shootValidator(table, targetCoordinateX, targetCoordinateY);
            if (targetShipChar == 'T') {
                scoreActual += 5;
                System.out.println("A játékos aktuális pontja:"+scoreActual);
                table[targetCoordinateX][targetCoordinateY] = targetShipChar;

            } else {
                scoreActual -= 1;
                System.out.println("A játékos aktuális pontja:"+scoreActual);
                table[targetCoordinateX][targetCoordinateY] = targetShipChar;
            }
        }
    }
