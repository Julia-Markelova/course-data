package ksuhaylia.coursedata.entity;

import javax.persistence.*;

/**
 * Класс является прототипом сущности-ассоциации используемой БД
 */
@Entity
@Table(name = "continents_remains")
@IdClass(ContinentsRemainsPK.class)
public class ContinentsRemains {
    private int continentId;
    private int remainId;

    @Id
    @Column(name = "continent_id", nullable = false)
    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    @Id
    @Column(name = "remain_id", nullable = false)
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

        ContinentsRemains that = (ContinentsRemains) o;

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
