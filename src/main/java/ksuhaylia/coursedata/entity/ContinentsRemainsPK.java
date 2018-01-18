package ksuhaylia.coursedata.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ContinentsRemainsPK implements Serializable {
    private int continentId;
    private int remainId;

    @Column(name = "continent_id", nullable = false)
    @Id
    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    @Column(name = "remain_id", nullable = false)
    @Id
    public int getRemainId() {
        return remainId;
    }

    public void setRemainId(int remainId) {
        this.remainId = remainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentsRemainsPK that = (ContinentsRemainsPK) o;

        if (continentId != that.continentId) return false;
        if (remainId != that.remainId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = continentId;
        result = 31 * result + remainId;
        return result;
    }
}
