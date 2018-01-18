package ksuhaylia.coursedata.entity;

import javax.persistence.*;
/**
 * Класс является прототипом сущности-ассоциации используемой БД
 */
@Entity
@Table(name = "literarure_eras")
@IdClass(LiterarureErasPK.class)
public class LiterarureEras {
    private int bookId;
    private int eraId;

    @Id
    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Id
    @Column(name = "era_id", nullable = false)
    public int getEraId() {
        return eraId;
    }

    public void setEraId(int eraId) {
        this.eraId = eraId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiterarureEras that = (LiterarureEras) o;

        if (bookId != that.bookId) return false;
        if (eraId != that.eraId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + eraId;
        return result;
    }
}
