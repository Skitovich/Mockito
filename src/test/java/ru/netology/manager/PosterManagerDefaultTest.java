package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerDefaultTest {


    PosterManager manager = new PosterManager();

    Poster first = new Poster(1, "Ruslan", "Skitovich", "Horror");
    Poster second = new Poster(2, "Titanik", "Leo", "Drama");
    Poster third = new Poster(3, "Interstellar", "UFO", "Fantastic");
    Poster forth = new Poster(3, "Interstellar", "UFO", "Fantastic");
    Poster five = new Poster(3, "Interstellar", "UFO", "Fantastic");
    Poster six = new Poster(3, "Interstellar", "UFO", "Fantastic");
    Poster seven = new Poster(3, "Interstellar", "UFO", "Fantastic");
    Poster eight = new Poster(3, "Interstellar", "UFO", "Fantastic");
    Poster nine = new Poster(3, "Interstellar", "UFO", "Fantastic");
    Poster ten = new Poster(3, "Interstellar", "UFO", "Fantastic");
    Poster eleven = new Poster(3, "Interstellar", "UFO", "Fantastic");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.getAll();
    }

    @Test
    public void shouldViewNineFilms() {
        Poster[] expected = new Poster[]{nine, eight, seven, six, five, forth, third, second, first};
        Poster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldViewTenFilms() {
        manager.add(ten);
        Poster[] expected = new Poster[]{ten, nine, eight, seven, six, five, forth, third, second, first};
        Poster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldViewElevenFilms() {
        manager.add(ten);
        manager.add(eleven);
        Poster[] expected = new Poster[]{eleven, ten, nine, eight, seven, six, five, forth, third, second};
        Poster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


}