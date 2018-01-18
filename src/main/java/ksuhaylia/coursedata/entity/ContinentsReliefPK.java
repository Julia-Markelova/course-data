package ksuhaylia.coursedata.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ContinentsReliefPK implements Serializable {
    private int continentId;
    private int reliefId;

    @Column(name = "continent_id", nullable = false)
    @Id
    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    @Column(name = "relief_id", nullable = false)
    @Id
    public int getReliefId() {
        return reliefId;
    }

    public void setReliefId(int reliefId) {
        this.reliefId = reliefId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentsReliefPK that = (ContinentsReliefPK) o;

        if (continentId != that.continentId) return false;
        if (reliefId != that.reliefId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = continentId;
        result = 31 * result + reliefId;
        return result;
    }
}
