package ksuhaylia.coursedata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ksuhaylia.coursedata.repository.ErasRepository;

import javax.persistence.*;
import java.time.chrono.Era;
import java.util.List;


/** Класс служит для хранения объектов со свойствами
 *<b>eraId</b>, <b>eraName</b>, <b>climate</b>,
 * которые характеризуют конкретную эру
 */

@Entity
public class Eras {
    /**
     * Свойство - уникальный идентификатор эры
     */

    private int eraId;
    /**
     * Свойство - название эры
     */
    private String eraName;
    /**
     * Свойство - преобладающий климат эры
     */
    private String climate;
    /**
     * Данные коллекции используются в методах, реализующих связь Many-to-Many
     * @see Eras#getContinents()
     * @see Eras#setContinents(List)
     * @see Eras#getLiterature()
     * @see Eras#setLiterature(List)
     * @see Eras#getHumans()
     * @see Eras#setHumans(List)
     */
    private List<Continents> continents;
    private List<Literature> literature;
    private List<Human> humans;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "era_id")
    public int getEraId() {
        return eraId;
    }

    public void setEraId(int eraId) {
        this.eraId = eraId;
    }

    @Basic
    @Column(name = "era_name", nullable = false)
    public String getEraName() {
        return eraName;
    }

    public void setEraName(String eraName) {
        this.eraName = eraName;
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
     * Метод, реализующий связь Many-to-Many с сущностью Континенты
     * @return возвращает список континентов
     */
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "eras_continents",
            joinColumns = @JoinColumn(name = "era_id", referencedColumnName = "era_id"),
            inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "continent_id"))
    public List<Continents> getContinents() {
        return continents;
    }

    public void setContinents(List<Continents> continents) {
        this.continents = continents;
    }

    /**
     * Метод, реализующий связь Many-to-Many с сущностью Литература
     * @return возвращает список литературных изданий
     */
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "literarure_eras",
            joinColumns = @JoinColumn(name = "era_id", referencedColumnName = "era_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"))
    public List<Literature> getLiterature() {
        return literature;
    }

    public void setLiterature(List<Literature> literature) {
        this.literature = literature;
    }

    /**
     * Метод, реализующий связь One-to-Many с сущностью Человек
     * @return возвращает список типов людей, живших в конкретную эру
     */
    @JsonIgnore
    @OneToMany(mappedBy = "eras", cascade = CascadeType.ALL)
    public List<Human> getHumans() {
        return humans;
    }

    public void setHumans(List<Human> humans) {
        this.humans = humans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Eras eras = (Eras) o;

        if (eraId != eras.eraId) return false;
        if (eraName != null ? !eraName.equals(eras.eraName) : eras.eraName != null) return false;
        if (climate != null ? !climate.equals(eras.climate) : eras.climate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eraId;
        result = 31 * result + (eraName != null ? eraName.hashCode() : 0);
        result = 31 * result + (climate != null ? climate.hashCode() : 0);
        return result;
    }



}
