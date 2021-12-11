package torpedo.service;

import java.util.Scanner;

import torpedo.model.MapVO;

/**
 * This Class takes the shot to the players' boards.
 *
 * @author István Szabó
 */
public class ShootTable {
    private MapVO mapVOPlayer01;
    private MapVO mapVOPlayer02;

    public ShootTable(MapVO mapVOPlayer02, MapVO mapVOPlayer01) {
        this.mapVOPlayer01 = mapVOPlayer01;
        this.mapVOPlayer02 = mapVOPlayer02;
    }

    /**
     * This method validates the hits on the Player02's map.
     *
     * @return  with the new map.
     */
    public MapVO shootValidatorPlayer01() {
        char[][] table2 = mapVOPlayer02.getMap();
        targetShipPlaces(table2);
        MapVO mapVO21 = new MapVO(mapVOPlayer02.getNumberOfRows(), mapVOPlayer02.getNumberOfColumns(), table2);
        return mapVO21;
    }

    /**
     * This method validates the hits on the Player01's map.
     *
     * @return  with the new map.
     */
    public MapVO shootValidatorPlayer02() {
        char[][] table1 = mapVOPlayer01.getMap();
        targetShipPlaces(table1);
        MapVO mapVO22 = new MapVO(mapVOPlayer01.getNumberOfRows(), mapVOPlayer01.getNumberOfColumns(), table1);
        return mapVO22;
    }

    private void targetShipPlaces(char[][] table) {
        char newShipChar = 'T';
        char newWaterChar = 'E';

        System.out.println("Add meg a cél koordinátákat!");
        Scanner shootCoordinateX = new Scanner(System.in);
        System.out.println("Sor koordináta");
        int targetCoordinateX = shootCoordinateX.nextInt();
        Scanner shootCoordinateY = new Scanner(System.in);
        System.out.println("Oszlop koordináta");
        int targetCoordinateY = shootCoordinateY.nextInt();
        if (table[targetCoordinateX][targetCoordinateY] == 'X') {
            table[targetCoordinateX][targetCoordinateY] = newShipChar;
        } else {
            table[targetCoordinateX][targetCoordinateY] = newWaterChar;
        }
    }
}
