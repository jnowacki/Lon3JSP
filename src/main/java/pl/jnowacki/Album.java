package pl.jnowacki;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDate;

public class Album implements Serializable {

    private String name;
    private String author;
    private Integer year;
    private Album.Genre genre;

    public Album() {
    }

    public Album(String name, String author, Integer year, Album.Genre genre) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isValid() {
        return !StringUtils.isBlank(name) &&
                !StringUtils.isBlank(author) &&
                genre != null &&
                year != null &&
                year > 1900 &&
                year <= LocalDate.now().getYear();
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                '}';
    }

    public enum Genre {
        ROCK, BLUES, COUNTRY, OTHER
    }
}
