package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerEmptyTest {
    PosterManager manager = new PosterManager();

    @Test
    public void shouldViewEmptyFilms() {
        Poster[] expected = new Poster[]{};
        Poster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}
