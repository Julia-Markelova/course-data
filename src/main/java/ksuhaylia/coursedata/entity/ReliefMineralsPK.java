package ksuhaylia.coursedata.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ReliefMineralsPK implements Serializable {
    private int reliefId;
    private int mineralId;

    @Column(name = "relief_id", nullable = false)
    @Id
    public int getReliefId() {
        return reliefId;
    }

    public void setReliefId(int reliefId) {
        this.reliefId = reliefId;
    }

    @Column(name = "mineral_id", nullable = false)
    @Id
    public int getMineralId() {
        return mineralId;
    }

    public void setMineralId(int mineralId) {
        this.mineralId = mineralId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReliefMineralsPK that = (ReliefMineralsPK) o;

        if (reliefId != that.reliefId) return false;
        if (mineralId != that.mineralId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reliefId;
        result = 31 * result + mineralId;
        return result;
    }
}
