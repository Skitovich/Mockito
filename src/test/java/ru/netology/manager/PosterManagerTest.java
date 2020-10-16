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
public class PosterManagerTest {

    Poster first = new Poster(1, "Ruslan", "Skitovich", "Horror");
    Poster second = new Poster(2, "Titanik", "Leo", "Drama");
    Poster third = new Poster(3, "Interstellar", "UFO", "Fantastic");
    Poster forth = new Poster(4, "Interstellar", "UFO", "Fantastic");
    Poster five = new Poster(5, "Interstellar", "UFO", "Fantastic");
    Poster six = new Poster(6, "Interstellar", "UFO", "Fantastic");
    Poster seven = new Poster(7, "Interstellar", "UFO", "Fantastic");
    Poster eight = new Poster(8, "Interstellar", "UFO", "Fantastic");
    Poster nine = new Poster(9, "Interstellar", "UFO", "Fantastic");
    Poster ten = new Poster(10, "Interstellar", "UFO", "Fantastic");
    Poster eleven = new Poster(11, "Interstellar", "UFO", "Fantastic");
    @Mock
    private PosterRepository repository;
    @InjectMocks

    private PosterManager manager = new PosterManager();

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

    }

    @Test
    public void shouldViewNineFilms() {


        Poster[] returned = new Poster[]{nine, eight, seven, six, five, forth, third, second, first};
        doReturn(returned).when(repository).findAll();
        Poster[] expected = new Poster[]{first, second, third, forth, five, six, seven, eight, nine};
        Poster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldViewTenFilms() {
        manager.add(ten);
        Poster[] returned = new Poster[]{ten, nine, eight, seven, six, five, forth, third, second, first};
        doReturn(returned).when(repository).findAll();
        Poster[] expected = new Poster[]{first, second, third, forth, five, six, seven, eight, nine, ten};
        Poster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldViewElevenFilms() {
        manager.add(ten);
        Poster[] returned = new Poster[]{eleven, ten, nine, eight, seven, six, five, forth, third, second, first};
        doReturn(returned).when(repository).findAll();
        Poster[] expected = new Poster[]{first, second, third, forth, five, six, seven, eight, nine, ten};
        Poster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

}