package ksuhaylia.coursedata.entity;

import javax.persistence.*;

/**
 * Класс является прототипом сущности-ассоциации используемой БД
 */
@Entity
@Table(name = "continents_relief")
@IdClass(ContinentsReliefPK.class)
public class ContinentsRelief {
    private int continentId;
    private int reliefId;

    @Id
    @Column(name = "continent_id", nullable = false)
    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    @Id
    @Column(name = "relief_id", nullable = false)
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

        ContinentsRelief that = (ContinentsRelief) o;

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
