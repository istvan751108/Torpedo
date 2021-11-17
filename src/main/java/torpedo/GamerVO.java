package torpedo;

import java.util.Objects;

public class GamerVO {
    private String nev;

    public GamerVO(String nev) {
        this.nev = nev;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamerVO GamerVO = (GamerVO) o;
        return Objects.equals(nev, GamerVO.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev);
    }

    @Override
    public String toString() {
        return "GamerVO nev" + nev;
    }
}
