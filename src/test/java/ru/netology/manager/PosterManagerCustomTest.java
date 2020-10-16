package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Poster;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class PosterManagerCustomTest {


    Poster first = new Poster(1, "Ruslan", "Skitovich", "Horror");
    Poster second = new Poster(2, "Titanik", "Leo", "Drama");
    Poster third = new Poster(3, "Interstellar", "UFO", "Fantastic");
    Poster forth = new Poster(4, "Interstellar", "UFO", "Fantastic");
    Poster five = new Poster(5, "Interstellar", "UFO", "Fantastic");
    Poster six = new Poster(6, "Interstellar", "UFO", "Fantastic");


    @Mock
    private PosterRepository repository;
    @InjectMocks
    private PosterManager manager = new PosterManager(repository, 5);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
    }


    @Test
    public void shouldViewForthFilms() {
        Poster[] returned = new Poster[]{forth, third, second, first};
        doReturn(returned).when(repository).findAll();
        Poster[] expected = new Poster[]{first, second, third, forth};
        Poster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldViewFiveFilms() {
        manager.add(five);
        Poster[] returned = new Poster[]{five, forth, third, second, first};
        doReturn(returned).when(repository).findAll();
        Poster[] expected = new Poster[]{first, second, third, forth, five};
        Poster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldViewSixFilms() {
        Poster[] returned = new Poster[]{six, five, forth, third, second, first};
        doReturn(returned).when(repository).findAll();
        Poster[] expected = new Poster[]{first, second, third, forth, five};
        Poster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }
}