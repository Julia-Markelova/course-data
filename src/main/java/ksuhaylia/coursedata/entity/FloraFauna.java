package ksuhaylia.coursedata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/** Класс служит для хранения объектов со свойствами
 *<b>animalId</b>, <b>animalName</b>, <b>currentLevelId</b>, <b>foodType</b>, <b>areal</b>, <b>parentId</b>, <b>remain</b>
 * которые характеризуют конкретную представителя флоры/фауны
 */
@Entity
//это чудо должно делать рекурсивный запрос прям к базе данных (я надеюсь) *НЕ РАБОТАЕТ*:
@NamedNativeQuery(name="selectParents", query="with recursive r(Animal_ID,Parent_ID,Animal_Name,path,level) as ( \n" +
                "select t1.Animal_ID, t1.Parent_ID, t1.Animal_Name, cast (t1.Animal_ID as varchar(10)) as path, 1 \n" +
                "from Flora_Fauna t1 where t1.Animal_ID = 1 \n" +
                "union \n" +
                "select t2.Animal_ID, t2.Parent_ID, t2.Animal_Name, cast (r.Animal_Name ||'=>'|| t2.Animal_Name as varchar(10)), level + 1 \n" +
                "from Flora_Fauna t2 inner join r on (r.Animal_ID = t2.Parent_ID)) \n" +
                "select * from r order by path;")
@Table(name = "flora_fauna")
public class FloraFauna {
    /**
     * Свойство - уникальный идентификатор живности
     */
    private int animalId;
    /**
     * Свойство - название живности
     */
    private String animalName;
    /**
     * Свойство - код текущего уровня (для реализации рекурсивной связи)
     */
    private Integer currentLevelId;
    /**
     * Свойство - тип питания живности
     */
    private String foodType;
    /**
     * Свойство - среда обитания живности
     */
    private String areal;
    /**
     * Свойство - код предка (для реализации рекурсивной связи)
     */
    private Integer parentId;
    private String image;
    /**
     * Объект класса Останки используется в методе, реализующем связь One-to-One
     * @see FloraFauna#getRemain()
     * @see FloraFauna#setRemain(Remains)
     */
    private Remains remain;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "animal_id", nullable = false)
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    @Basic
    @Column(name = "animal_name", nullable = false)
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Basic
    @Column(name = "current_level_id", nullable = true)
    public Integer getCurrentLevelId() {
        return currentLevelId;
    }

    public void setCurrentLevelId(Integer currentLevelId) {
        this.currentLevelId = currentLevelId;
    }

    @Basic
    @Column(name = "food_type", nullable = true)
    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Basic
    @Column(name = "areal", nullable = true)
    public String getAreal() {
        return areal;
    }

    public void setAreal(String areal) {
        this.areal = areal;
    }

    @Basic
    @Column(name = "parent_id", nullable = true)
    public Integer getParentId() {
        return parentId;
    }


    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "image", nullable = true)
    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }


    /**
     * Метод, реализующий связь One-to-One с сущностью Останки
     * @return возвращает останок конкретного представителя
     */

    @OneToOne(mappedBy = "floraFauna")
    public Remains getRemain() {
        return remain;
    }

    public void setRemain(Remains remain) {
        this.remain = remain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FloraFauna that = (FloraFauna) o;

        if (animalId != that.animalId) return false;
        if (animalName != null ? !animalName.equals(that.animalName) : that.animalName != null) return false;
        if (currentLevelId != null ? !currentLevelId.equals(that.currentLevelId) : that.currentLevelId != null)
            return false;
        if (foodType != null ? !foodType.equals(that.foodType) : that.foodType != null) return false;
        if (areal != null ? !areal.equals(that.areal) : that.areal != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = animalId;
        result = 31 * result + (animalName != null ? animalName.hashCode() : 0);
        result = 31 * result + (currentLevelId != null ? currentLevelId.hashCode() : 0);
        result = 31 * result + (foodType != null ? foodType.hashCode() : 0);
        result = 31 * result + (areal != null ? areal.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }
}
