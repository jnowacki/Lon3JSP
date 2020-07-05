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

//        assertTrue();
//        assertFalse();
    }

    @Test
    public void shouldBeInvalidWhenSomeFieldsAreNull() {

//        assertTrue();
//        assertFalse();
    }
}
