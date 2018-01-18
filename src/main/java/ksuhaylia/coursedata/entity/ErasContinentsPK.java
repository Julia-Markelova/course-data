package ksuhaylia.coursedata.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ErasContinentsPK implements Serializable {
    private int eraId;
    private int continentId;

    @Column(name = "era_id", nullable = false)
    @Id
    public int getEraId() {
        return eraId;
    }

    public void setEraId(int eraId) {
        this.eraId = eraId;
    }

    @Column(name = "continent_id", nullable = false)
    @Id
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

        ErasContinentsPK that = (ErasContinentsPK) o;

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
