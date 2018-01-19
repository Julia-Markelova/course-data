package ksuhaylia.coursedata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

/** Класс служит для хранения объектов со свойствами
 *<b>mineralId</b>, <b>mineralName</b>, <b>chemistryStructure</b>, <b>price</b>,
 * которые характеризуют минерал
 */
@Entity
public class Minerals {
    /**
     * Свойство - уникальный идентификатор минерала
     */
    private int mineralId;
    /**
     * Свойство - название минерала
     */
    private String mineralName;
    /**
     * Свойство - химический состав минерала
     */
    private String chemistryStructure;
    /**
     * Свойство - стоимость минерала
     */
    private BigInteger price;
    /**
     * Данная коллекция используется в методах, реализующих связь Many-to-Many
     * @see Minerals#getReliefs()
     * @see Minerals#setReliefs(List)
     */
    private List<Relief> reliefs;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mineral_id", nullable = false)
    public int getMineralId() {
        return mineralId;
    }

    public void setMineralId(int mineralId) {
        this.mineralId = mineralId;
    }

    @Basic
    @Column(name = "mineral_name", nullable = false)
    public String getMineralName() {
        return mineralName;
    }

    public void setMineralName(String mineralName) {
        this.mineralName = mineralName;
    }

    @Basic
    @Column(name = "chemistry_structure", nullable = true)
    public String getChemistryStructure() {
        return chemistryStructure;
    }

    public void setChemistryStructure(String chemistryStructure) {
        this.chemistryStructure = chemistryStructure;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }
    /**
     * Метод, реализующий связь Many-to-Many с сущностью Рельеф
     * @return возвращает список типов рельефов, на которых есть минералы
     */

    @ManyToMany(mappedBy = "minerals")
    public List<Relief> getReliefs() {
        return reliefs;
    }
    public void setReliefs(List<Relief> reliefs) {
        this.reliefs = reliefs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Minerals minerals = (Minerals) o;

        if (mineralId != minerals.mineralId) return false;
        if (mineralName != null ? !mineralName.equals(minerals.mineralName) : minerals.mineralName != null)
            return false;
        if (chemistryStructure != null ? !chemistryStructure.equals(minerals.chemistryStructure) : minerals.chemistryStructure != null)
            return false;
        if (price != null ? !price.equals(minerals.price) : minerals.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mineralId;
        result = 31 * result + (mineralName != null ? mineralName.hashCode() : 0);
        result = 31 * result + (chemistryStructure != null ? chemistryStructure.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
