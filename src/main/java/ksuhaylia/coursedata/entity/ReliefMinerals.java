package ksuhaylia.coursedata.entity;

import javax.persistence.*;
/**
 * Класс является прототипом сущности-ассоциации используемой БД
 */
@Entity
@Table(name = "relief_minerals")
@IdClass(ReliefMineralsPK.class)
public class ReliefMinerals {
    private int reliefId;
    private int mineralId;

    @Id
    @Column(name = "relief_id", nullable = false)
    public int getReliefId() {
        return reliefId;
    }

    public void setReliefId(int reliefId) {
        this.reliefId = reliefId;
    }

    @Id
    @Column(name = "mineral_id", nullable = false)
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

        ReliefMinerals that = (ReliefMinerals) o;

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
