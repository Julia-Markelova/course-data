package ksuhaylia.coursedata.entity;

import javax.persistence.*;
/**
 * Класс является прототипом сущности-ассоциации используемой БД
 */
@Entity
@Table(name = "eras_continents")
@IdClass(ErasContinentsPK.class)
public class ErasContinents {
    private int eraId;
    private int continentId;

    @Id
    @Column(name = "era_id", nullable = false)
    public int getEraId() {
        return eraId;
    }

    public void setEraId(int eraId) {
        this.eraId = eraId;
    }

    @Id
    @Column(name = "continent_id", nullable = false)
    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErasContinents that = (ErasContinents) o;

        if (eraId != that.eraId) return false;
        if (continentId != that.continentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eraId;
        result = 31 * result + continentId;
        return result;
    }
}
