package torpedo.model;

import java.util.Objects;

/**
 * This is the Gamer Value Object Class.
 *
 * @author István Szabó
 */
public class GamerVO {
    private String name;
    private int point;

    public GamerVO(String name) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void setNev(String name) {
        this.name = name;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        torpedo.model.GamerVO gamerVO = (torpedo.model.GamerVO) o;
        return Objects.equals(name, gamerVO.name);
    }

    public GamerVO(String player1, int i) {

    }

    @Override
    public String toString() {
        return "GamerVO name" + name + "Point: " + point;
    }
}
