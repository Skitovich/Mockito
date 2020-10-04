package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;
import ru.netology.manager.PosterManager;

import static org.junit.jupiter.api.Assertions.*;

class PosterRepositoryTest {
    private PosterRepository repository;
    private PosterManager manager;

    private Poster first = new Poster(1, "Ruslan", "Skitovich", "Horror");
    private Poster second = new Poster(2, "Titanik", "Leo", "Drama");

    @Test
    void testSave() {
    }

    @Test
    void testFindAll() {
    }

    @Test
    void testRemoveById() {
    }

    @Test
    void findById() {
        manager.add(first);
        manager.add(second);

        System.out.println(repository.findById(3));
        Poster actual = repository.findById(2);
        Poster expected = repository.findById(1);
        assertEquals(expected,actual);

    }

    @Test
    void testRemoveAll() {
    }
}
