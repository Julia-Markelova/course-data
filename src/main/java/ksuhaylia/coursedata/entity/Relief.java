package ksuhaylia.coursedata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/** Класс служит для хранения объектов со свойствами
 *<b>reliefId</b>, <b>reliefName</b>, <b>height</b>,
 * которые характеризуют рельеф местности
 */
@Entity
public class Relief {
    /**
     * Свойство - уникальный идентификатор рельефа
     */
    private int reliefId;
    /**
     * Свойство - название рельефа
     */
    private String reliefName;
    /**
     * Свойство - высота рельефа
     */
    private Double height;
    /**
     * Данные коллекции используются в методах, реализующих связь Many-to-Many
     * @see Relief#setContinents(List)
     * @see Relief#getContinents()
     * @see Relief#setMinerals(List)
     * @see Relief#getContinents()
     */
    private List<Continents> continents;
    private List<Minerals> minerals;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "relief_id", nullable = false)
    public int getReliefId() {
        return reliefId;
    }

    public void setReliefId(int reliefId) {
        this.reliefId = reliefId;
    }

    @Basic
    @Column(name = "relief_name", nullable = true)
    public String getReliefName() {
        return reliefName;
    }

    public void setReliefName(String reliefName) {
        this.reliefName = reliefName;
    }

    @Basic
    @Column(name = "height", nullable = true, precision = 0)
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
    /**
     * Метод, реализующий связь Many-to-Many с сущностью Континенты
     * @return возвращает список континентов, на которых можно встретить данные типы рельефов
     */
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "continents_relief",
            joinColumns = @JoinColumn(name = "relief_id", referencedColumnName = "relief_id"),
            inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "continent_id"))
    public List<Continents> getContinents() {
        return continents;
    }

    public void setContinents(List<Continents> continents) {
        this.continents = continents;
    }

    /**
     * Метод, реализующий связь Many-to-Many с сущностью Минералы
     * @return возвращает список минералов, которые встречаются на рельефах
     */
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "relief_minerals",
            joinColumns = @JoinColumn(name = "relief_id", referencedColumnName = "relief_id"),
            inverseJoinColumns = @JoinColumn(name = "mineral_id", referencedColumnName = "mineral_id"))
    public List<Minerals> getMinerals() {
        return minerals;
    }

    public void setMinerals(List<Minerals> minerals) {
        this.minerals = minerals;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Relief relief = (Relief) o;

        if (reliefId != relief.reliefId) return false;
        if (reliefName != null ? !reliefName.equals(relief.reliefName) : relief.reliefName != null) return false;
        if (height != null ? !height.equals(relief.height) : relief.height != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reliefId;
        result = 31 * result + (reliefName != null ? reliefName.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        return result;
    }
}
