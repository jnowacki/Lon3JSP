package pl.jnowacki;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlbumTest {

    @Test
    public void shouldBeValidWhenAllFieldsAreNotEmpty() {

        Album album = new Album("name", "author", 1999, Album.Genre.BLUES);

        assertTrue(album.isValid());
    }

    @Test
    public void shouldBeInvalidWhenSomeFieldsAreEmpty() {

        Album album = new Album("name", "   ", 2000, Album.Genre.BLUES);
        assertFalse(album.isValid());
    }

    @Test
    public void shouldBeInvalidWhenSomeFieldsAreNull() {

        Album album = new Album(null, "author", 2000, Album.Genre.BLUES);
        assertFalse(album.isValid());
    }

    @Test
    public void shouldBeInvalidWhenYearFromTheFuture() {

        Album album = new Album(null, "author", 2100, Album.Genre.BLUES);
        assertFalse(album.isValid());
    }

    @Test
    public void shouldBeInvalidWhenYearBefore1900() {

        Album album = new Album(null, "author", 1899, Album.Genre.BLUES);
        assertFalse(album.isValid());
    }

    @Test
    public void shouldBeInvalidWhenYearIsNull() {

        Album album = new Album(null, "author", null, Album.Genre.BLUES);
        assertFalse(album.isValid());
    }
}
