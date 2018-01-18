package ksuhaylia.coursedata.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class LiterarureErasPK implements Serializable {
    private int bookId;
    private int eraId;

    @Column(name = "book_id", nullable = false)
    @Id
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Column(name = "era_id", nullable = false)
    @Id
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

        LiterarureErasPK that = (LiterarureErasPK) o;

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
