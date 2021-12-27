package torpedo.model;

import java.util.Objects;

/**
 * This is the Gamer Value Object Class.
 *
 * @author István Szabó
 */
public class GamerVO {
    private String name;

    public GamerVO(String name) {
        this.name = name;
    }

    public GamerVO() {

    }

    public String getName() {
        return name;
    }

    public void setNev(String name) {
        this.name = name;
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

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "GamerVO name" + name;
    }
}
