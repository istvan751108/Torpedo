package torpedo.service;

import torpedo.model.MapVO;
import torpedo.service.PlayerTable;
import java.util.Scanner;

public class ShootTable {

        boolean actualCoordinateDecision=true;
        int scoreActual = 1000;
        private final int numberOfRows;
        private final int numberOfColumns;

        public ShootTable(int numberOfRows, int numberOfColumns) {
            this.numberOfRows = numberOfRows;
            this.numberOfColumns = numberOfColumns;
        }

        public PlayerTable createNewShooterTable() {
            char[][] table = getTable();
            return new PlayerTable(numberOfRows, numberOfColumns);
        }

        private char[][] getTable() {
            char[][] table = new char[numberOfRows][numberOfColumns];
            System.out.println("Add meg a cél koordinátákat!");
            targetShipPlaces(table);
            return table;
        }

        private void targetShipPlaces(char[][] table) {
            char newShipChar = 'T';
            char newWaterChar = 'O';

            Scanner shootCoordinateX = new Scanner(System.in);
            System.out.println("Sor koordináta");
            int targetCoordinateX = shootCoordinateX.nextInt();
            Scanner shootCoordinateY = new Scanner(System.in);
            System.out.println("Oszlop koordináta");
            int targetCoordinateY = shootCoordinateY.nextInt();
            if (table[targetCoordinateX][targetCoordinateY] == 'X') {
                table[targetCoordinateX][targetCoordinateY]= newShipChar;
                scoreActual += 5;
            } else {
                table[targetCoordinateX][targetCoordinateY]= newWaterChar;
                scoreActual -= 1;
            }
        }
    }
