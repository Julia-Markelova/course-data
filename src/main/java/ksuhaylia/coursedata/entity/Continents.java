package ksuhaylia.coursedata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


/** Класс служит для хранения объектов со свойствами
 *<b>continentId</b>, <b>continentName</b>, <b>square</b>, <b>climate</b>,
 * которые характеризуют конкретный континент
 */

@Entity
public class Continents {
    /**
     * Свойство - уникальный идентификатор континента
     */
    private int continentId;
    /**
     * Свойство - название континента
     */
    private String continentName;
    /**
     * Свойство - площадь континента
     */
    private Double square;
    /**
     * Свойство - климат континента
     */
    private String climate;

    /**
     * Данные коллекции используются в методах, реализующих связь Many-to-Many
     */
    private List<Eras> eras;
    private List<Relief> reliefs;
    private List<Remains> remains;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "continent_id", nullable = false)
    public int getContinentId() {
        return continentId;
    }
    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    @Basic
    @Column(name = "continent_name", nullable = false)
    public String getContinentName() {
        return continentName;
    }
    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    @Basic
    @Column(name = "square", nullable = true)
    public Double getSquare() {
        return square;
    }
    public void setSquare(Double square) {
        this.square = square;
    }

    @Basic
    @Column(name = "climate", nullable = true)
    public String getClimate() {
        return climate;
    }
    public void setClimate(String climate) {
        this.climate = climate;
    }

    /**
     * Метод, реализующий связь Many-to-Many с сущностью Эры
     * @return возвращает список эр
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "continents")
    public List<Eras> getEras() {
        return eras;
    }
    public void setEras(List<Eras> eras) {
        this.eras = eras;
    }

    /**
     * Метод, реализующий связь Many-to-Many с сущностью Рельеф
     * @return возвращает список типов рельефов
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "continents")
    public List<Relief> getReliefs() {
        return reliefs;
    }
    public void setReliefs(List<Relief> reliefs) {
        this.reliefs = reliefs;
    }

    /**
     * Метод, реализующий связь Many-to-Many с сущностью Останки
     * @return возвращает список останков
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "continents")
    public List<Remains> getRemains() {
        return remains;
    }
    public void setRemains(List<Remains> remains) {
        this.remains = remains;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continents that = (Continents) o;

        if (continentId != that.continentId) return false;
        if (continentName != null ? !continentName.equals(that.continentName) : that.continentName != null)
            return false;
        if (square != null ? !square.equals(that.square) : that.square != null) return false;
        if (climate != null ? !climate.equals(that.climate) : that.climate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = continentId;
        result = 31 * result + (continentName != null ? continentName.hashCode() : 0);
        result = 31 * result + (square != null ? square.hashCode() : 0);
        result = 31 * result + (climate != null ? climate.hashCode() : 0);
        return result;
    }
}
