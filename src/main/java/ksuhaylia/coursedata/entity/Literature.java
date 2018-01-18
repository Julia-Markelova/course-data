package ksuhaylia.coursedata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.chrono.Era;
import java.util.List;

/** Класс служит для хранения объектов со свойствами
 *<b>bookId</b>, <b>bookName</b>, <b>author</b>, <b>publishingHouse</b>, <b>price</b>,
 * которые характеризуют литературное произведение
 */
@Entity
public class Literature {
    /**
     * Свойство - уникальный идентификатор книги
     */
    private int bookId;
    /**
     * Свойство - название книги
     */
    private String bookName;
    /**
     * Свойство - автор книги
     */
    private String author;
    /**
     * Свойство - название издательства
     */
    private String publishingHouse;
    /**
     * Свойство - стоимость книги
     */
    private double price;
    /**
     * Данная коллекция используется в методах, реализующих связь Many-to-Many
     * @see Literature#getEras()
     * @see Literature#setEras(List)
     */
    private List<Eras> eras;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "book_name", nullable = false)
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "author", nullable = false)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "publishing_house", nullable = true)
    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Метод, реализующий связь Many-to-Many с сущностью Эры
     * @return возвращает список эр, о которых есть информация в книгах
     */

    @ManyToMany(mappedBy = "literature")
    public List<Eras> getEras() {
        return eras;
    }
    public void setEras(List<Eras> eras) {
        this.eras = eras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Literature that = (Literature) o;

        if (bookId != that.bookId) return false;
        if (bookName != null ? !bookName.equals(that.bookName) : that.bookName != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (publishingHouse != null ? !publishingHouse.equals(that.publishingHouse) : that.publishingHouse != null)
            return false;
       /* if (price != null ? !price.equals(that.price) : that.price != null) return false;*/

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publishingHouse != null ? publishingHouse.hashCode() : 0);
        /*result = 31 * result + (price != null ? price.hashCode() : 0);*/
        return result;
    }
}
