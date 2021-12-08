package torpedo.service;

import torpedo.model.MapVO;
import java.util.Scanner;

public class ShootTable {
    private MapVO mapVOEnemy, mapVOOwn;

    public ShootTable(MapVO mapVO1, MapVO mapVO2) {
        this.mapVOEnemy = mapVO1;
        this.mapVOOwn = mapVO2;
    }

    public MapVO shootValidatorPlayer01() {
        char[][] table = mapVOEnemy.getMap();
        targetShipPlaces(table);
        MapVO mapVO21 = new MapVO(mapVOEnemy.getNumberOfRows(), mapVOEnemy.getNumberOfColumns(), table);
        return mapVO21;
    }
    public MapVO shootValidatorPlayer02() {
        char[][] table = mapVOOwn.getMap();
        targetShipPlaces(table);
        MapVO mapVO21 = new MapVO(mapVOOwn.getNumberOfRows(), mapVOOwn.getNumberOfColumns(), table);
        return mapVO21;
    }

    private void targetShipPlaces(char[][] table) {
        int scoreActual = 1000;
        char newShipChar = 'T';
        char newWaterChar = 'O';

        System.out.println("Add meg a cél koordinátákat!");
        Scanner shootCoordinateX = new Scanner(System.in);
        System.out.println("Sor koordináta");
        int targetCoordinateX = shootCoordinateX.nextInt();
        Scanner shootCoordinateY = new Scanner(System.in);
        System.out.println("Oszlop koordináta");
        int targetCoordinateY = shootCoordinateY.nextInt();
        if (table[targetCoordinateX][targetCoordinateY] == 'X') {
            table[targetCoordinateX][targetCoordinateY] = newShipChar;
            scoreActual += 5;
        } else {
            table[targetCoordinateX][targetCoordinateY] = newWaterChar;
            scoreActual -= 1;
        }
    }
}
