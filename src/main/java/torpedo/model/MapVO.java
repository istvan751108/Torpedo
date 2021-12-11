package torpedo.model;

import java.util.Arrays;
import java.util.Objects;

/**
 * This is the Play's Map Value Object Class.
 *
 * @author István Szabó
 */
public final class MapVO {

    private final int numberOfRows;
    private final int numberOfColumns;
    private final char[][] map;

    public MapVO(int numberOfRows, int numberOfColumns, char[][] map) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.map = deepCopy(map);
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public char[][] getMap() {
        return deepCopy(this.map);
    }

    private char[][] deepCopy(char[][] map) {
        char[][] result = new char[map.length][];

        for (int i = 0; i < map.length; i++) {
            result[i] = new char[map[i].length];
            for (int j = 0; j < map[i].length; j++) {
                result[i][j] = map[i][j];
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MapVO mapVO = (MapVO) o;
        return numberOfRows == mapVO.numberOfRows && numberOfColumns == mapVO.numberOfColumns && Arrays.deepEquals(map, mapVO.map);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfRows, numberOfColumns);
        result = 31 * result + Arrays.deepHashCode(map);
        return result;
    }

    @Override
    public String toString() {
        return "\n " + Arrays.deepToString(map).replace("],", "\n").replace(",", "\t ")
                .replaceAll("[\\[\\]]", "");
    }
}