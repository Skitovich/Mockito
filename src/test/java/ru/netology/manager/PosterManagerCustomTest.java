package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class PosterManagerCustomTest {

    PosterManager manager = new PosterManager(5);


    Poster first = new Poster(1, "Ruslan", "Skitovich", "Horror");
    Poster second = new Poster(2, "Titanik", "Leo", "Drama");
    Poster third = new Poster(3, "Interstellar", "UFO", "Fantastic");
    Poster forth = new Poster(4, "Interstellar", "UFO", "Fantastic");
    Poster five = new Poster(5, "Interstellar", "UFO", "Fantastic");
    Poster six = new Poster(6, "Interstellar", "UFO", "Fantastic");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
    }


    @Test
    public void shouldViewNineFilms() {
        Poster[] actual = new Poster[]{forth, third, second, first};
        Poster[] expected = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldViewFiveFilms() {
        manager.add(five);
        Poster[] actual = new Poster[]{five, forth, third, second, first};
        Poster[] expected = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldViewSixFilms() {
        manager.add(five);
        manager.add(six);
        Poster[] actual = new Poster[]{five, forth, third, second, first};
        Poster[] expected = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}
