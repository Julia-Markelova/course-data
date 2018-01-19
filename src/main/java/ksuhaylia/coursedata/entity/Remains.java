package ksuhaylia.coursedata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/** Класс служит для хранения объектов со свойствами
 *<b>remainId</b>, <b>groupOfArchaeologists</b>, <b>remainAge</b>,
 * которые характеризуют найденные останки
 */
@Entity
public class Remains {
    /**
     * Свойство - уникальный идентификатор останка
     */
    private int remainId;
    /**
     * Свойство - название группы археологов, нашедших останок
     */
    private String groupOfArchaeologists;
    /**
     * Свойство - возраст останка
     */
    private Integer remainAge;
    /**
     * Данная коллекция используется в методах, реализующих связь Many-to-Many
     * @see Remains#getContinents()
     * @see Remains#setContinents(List)
     */
    private List<Continents> continents;
    /**
     * Объект класса Флора и Фауна используется в методе, реализующем связь One-to-One
     * @see Remains#getFloraFauna()
     * @see Remains#setFloraFauna(FloraFauna)
     */
    private FloraFauna floraFauna;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "remain_id", nullable = false)
    public int getRemainId() {
        return remainId;
    }

    public void setRemainId(int remainId) {
        this.remainId = remainId;
    }


    @Basic
    @Column(name = "group_of_archaeologists", nullable = true)
    public String getGroupOfArchaeologists() {
        return groupOfArchaeologists;
    }

    public void setGroupOfArchaeologists(String groupOfArchaeologists) {
        this.groupOfArchaeologists = groupOfArchaeologists;
    }

    @Basic
    @Column(name = "remain_age", nullable = true)
    public Integer getRemainAge() {
        return remainAge;
    }

    public void setRemainAge(Integer remainAge) {
        this.remainAge = remainAge;
    }

    /**
     * Метод, реализующий связь Many-to-Many с сущностью Континенты
     * @return возвращает список континентов
     */
    @ManyToMany
    @JoinTable(name = "continents_remains",
            joinColumns = @JoinColumn(name = "remain_id", referencedColumnName = "remain_id"),
            inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "continent_id"))
    public List<Continents> getContinents() {
        return continents;
    }

    public void setContinents(List<Continents> continents) {
        this.continents = continents;
    }

    /**
     * Метод, реализующий связь One-to-One с Флора и Фауна
     * @return возвращает конкретное животное, останок которого был найден
     */
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="animal_id")
    public FloraFauna getFloraFauna() {
        return floraFauna;
    }

    public void setFloraFauna(FloraFauna floraFauna) {
        this.floraFauna = floraFauna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Remains remains = (Remains) o;

        if (remainId != remains.remainId) return false;
        if (groupOfArchaeologists != null ? !groupOfArchaeologists.equals(remains.groupOfArchaeologists) : remains.groupOfArchaeologists != null)
            return false;
        if (remainAge != null ? !remainAge.equals(remains.remainAge) : remains.remainAge != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = remainId;
        result = 31 * result + (groupOfArchaeologists != null ? groupOfArchaeologists.hashCode() : 0);
        result = 31 * result + (remainAge != null ? remainAge.hashCode() : 0);
        return result;
    }
}
