package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerEmptyTest {
    PosterManager manager = new PosterManager();

    @Test
    public void shouldViewNineFilms() {
        Poster[] actual = new Poster[]{};
        Poster[] expected = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}
