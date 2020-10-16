package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;
import ru.netology.manager.PosterManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PosterRepositoryTest {
    private Poster poster = new Poster();
    private PosterRepository repository = new PosterRepository();
    private PosterManager manager = new PosterManager(repository);


    private Poster first = new Poster(1, "Interstellar", "UFO", "Fantastic");
    private Poster second = new Poster(2, "Interstellar", "UFO", "Fantastic");
    private Poster third = new Poster(3, "Interstellar", "UFO", "Fantastic");
    private Poster forth = new Poster(4, "Interstellar", "UFO", "Fantastic");
    private Poster five = new Poster(5, "Interstellar", "UFO", "Fantastic");
    private Poster six = new Poster(6, "Interstellar", "UFO", "Fantastic");
    private Poster seven = new Poster(7, "Interstellar", "UFO", "Fantastic");
    private Poster eight = new Poster(8, "Interstellar", "UFO", "Fantastic");
    private Poster nine = new Poster(9, "Interstellar", "UFO", "Fantastic");
    private Poster ten = new Poster(10, "Interstellar", "UFO", "Fantastic");
    private Poster eleven = new Poster(11, "Interstellar", "UFO", "Fantastic");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

    }

    @Test
    void findById() {
        Poster poster = new Poster(1, "Interstellar", "UFO", "Fantastic");
        repository.findById(1);
        Poster expected = repository.findById(first.getId());
        Poster actual = first;
        assertEquals(expected, actual);

    }

    @Test
    void findByIdNotExist() {
        Poster poster = new Poster(0, "Interstellar", "UFO", "Fantastic");
        repository.findById(2);
        Poster expected = null;
        Poster actual = repository.findById(12);
        assertEquals(expected, actual);

    }


    @Test
    void save() {

        repository.save(forth);
        Poster[] expected = new Poster[]{first, second, third, forth};
        Poster[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        repository.removeById(idToRemove);

        Poster[] expected = new Poster[]{second, third};
        Poster[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        int idToRemove = 3;
        repository.removeById(idToRemove);
        Poster[] actual = new Poster[]{second, first};
        Poster[] expected = manager.getAll();
        assertArrayEquals(actual, expected);

    }

}

