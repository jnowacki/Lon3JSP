package pl.jnowacki;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlbumTest {

    @Test
    public void shouldBeValidWhenAllFieldsAreNotEmpty() {

        Album album = new Album("name", "author", "year");

        assertTrue(album.isValid());
    }

    @Test
    public void shouldBeInvalidWhenSomeFieldsAreEmpty() {

        Album album = new Album("name", "   ", "year");
        assertFalse(album.isValid());
    }

    @Test
    public void shouldBeInvalidWhenSomeFieldsAreNull() {

        Album album = new Album(null, "author", "year");
        assertFalse(album.isValid());
    }
}
