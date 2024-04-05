package nl.miwnn.se13.vincent.librarydemo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

/**
 * @author Vincent Velthuizen
 * Represents a book that can have copies
 **/

@SuppressWarnings("unused")
@Entity
public class Book {
    @Id @GeneratedValue
    private Long bookId;

    @Column(unique = true)
    private String title;

    @ManyToMany(cascade = CascadeType.DETACH)
    private Set<Author> authors;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Copy> copies;

    public int getNumberOfAvailableCopies() {
        int count = 0;

        for (Copy copy : copies) {
            if (copy.getAvailable()) {
                count++;
            }
        }

        return count;
    }

    public int getTotalNumberOfCopies() {
        return copies.size();
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }
}
