package ksuhaylia.coursedata.entity;

import ksuhaylia.coursedata.repository.HumanRepository;

import javax.persistence.*;
import java.util.List;

/** Класс служит для хранения объектов со свойствами
 *<b>humanId</b>, <b>humanName</b>, <b>lifeTime</b>, <b>height</b>, <b>weight</b>, <b>tools</b>, <b>hobby</b>
 * которые характеризуют человека в конкретную эру
 */
@Entity
public class Human {
    /**
     * Свойство - уникальный идентификатор человека
     */
    private int humanId;
 //   private Integer eraId;
    /**
     * Свойство - название человека, жившего в определенную эру
     */
    private String humanName;
    /**
     * Свойство - продолжительность жизни человека
     */
    private Integer lifeTime;
    /**
     * Свойство - рост человека
     */
    private Double height;
    /**
     * Свойство - вес человека
     */
    private Double weight;
    /**
     * Свойство - орудия труда, используемые человеком
     */
    private String tools;
    /**
     * Свойство - деятельность человека
     */
    private String hobby;
    /**
     * Объект класса Эры используется в методе, реализующем связь Many-to-One
     * @see Human#getEras()
     * @see Human#setEras(Eras)
     */
    private Eras eras;


    @Override
    public String toString() {
        return "id = " + this.humanId +" name = " + this.humanName
                + "era="+this.getEras().getEraName();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "human_id", nullable = false)
    public int getHumanId() {
        return humanId;
    }

    public void setHumanId(int humanId) {
        this.humanId = humanId;
    }

/*    @Basic
    @Column(name = "era_id", nullable = true)
    public Integer getEraId() {
        return eraId;
    }

    public void setEraId(Integer eraId) {
        this.eraId = eraId;
    }*/

    @Basic
    @Column(name = "human_name", nullable = false)
    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    @Basic
    @Column(name = "life_time", nullable = true)
    public Integer getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(Integer lifeTime) {
        this.lifeTime = lifeTime;
    }

    @Basic
    @Column(name = "height", nullable = true, precision = 0)
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Basic
    @Column(name = "weight", nullable = true, precision = 0)
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "tools", nullable = true)
    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    @Basic
    @Column(name = "hobby", nullable = true)
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    /**
     * Метод, реализующий связь Many-to-One с сущностью Эры
     * @return возвращает эру, в которой жили представители нескольких типов людей
     */
    @ManyToOne
    @JoinColumn(name = "era_id")
    public Eras getEras() {
        return eras;
    }

    public void setEras(Eras eras) {
        this.eras = eras;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (humanId != human.humanId) return false;
    //    if (eraId != null ? !eraId.equals(human.eraId) : human.eraId != null) return false;
        if (humanName != null ? !humanName.equals(human.humanName) : human.humanName != null) return false;
        if (lifeTime != null ? !lifeTime.equals(human.lifeTime) : human.lifeTime != null) return false;
        if (height != null ? !height.equals(human.height) : human.height != null) return false;
        if (weight != null ? !weight.equals(human.weight) : human.weight != null) return false;
        if (tools != null ? !tools.equals(human.tools) : human.tools != null) return false;
        if (hobby != null ? !hobby.equals(human.hobby) : human.hobby != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = humanId;
     //   result = 31 * result + (eraId != null ? eraId.hashCode() : 0);
        result = 31 * result + (humanName != null ? humanName.hashCode() : 0);
        result = 31 * result + (lifeTime != null ? lifeTime.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (tools != null ? tools.hashCode() : 0);
        result = 31 * result + (hobby != null ? hobby.hashCode() : 0);
        return result;
    }
}
