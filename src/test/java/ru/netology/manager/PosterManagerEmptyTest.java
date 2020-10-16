package ru.netology.manager;

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
public class PosterManagerEmptyTest {
    @InjectMocks

    PosterManager manager = new PosterManager();
    @Mock
    private PosterRepository repository;

    @Test
    public void shouldViewEmptyFilms() {
        Poster[] returned = new Poster[]{};
        doReturn(returned).when(repository).findAll();
        Poster[] expected = new Poster[]{};
        Poster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}