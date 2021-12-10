package torpedo.service;

import torpedo.model.MapVO;

public class CheckerTable {
    private MapVO checkerTable02, checkerTable01;

    public CheckerTable(MapVO checkerTable02, MapVO checkerTable01) {
        this.checkerTable02 = checkerTable02;
        this.checkerTable01 = checkerTable01;
    }

    public MapVO checkerTablePlayer01() {
        char[][] table = checkerTable02.getMap();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((table[i][j] != 'T')&&(table[i][j] != 'E')) {
                    table[i][j] = ' ';
                }
            }
        }
        MapVO mapVO23 = new MapVO(checkerTable02.getNumberOfRows(), checkerTable02.getNumberOfColumns(), table);
        return mapVO23;
    }
    public MapVO checkerTablePlayer02() {
        char[][] table = checkerTable01.getMap();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((table[i][j] != 'T')&&(table[i][j] != 'E')){
                    table[i][j] = ' ';
                }
            }
        }
        MapVO mapVO24 = new MapVO(checkerTable01.getNumberOfRows(), checkerTable01.getNumberOfColumns(), table);
        return mapVO24;
    }
}
