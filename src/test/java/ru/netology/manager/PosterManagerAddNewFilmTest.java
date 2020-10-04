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
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class PosterManagerAddNewFilmTest {
    @Mock
    private PosterRepository repository;
    @InjectMocks
    private PosterManager manager;
    private Poster first = new Poster(1,"Interstellar", "UFO", "Fantastic");
    private Poster second = new Poster(2,"Interstellar", "UFO", "Fantastic");
    private Poster third = new Poster(3, "Interstellar", "UFO", "Fantastic");
    private Poster forth = new Poster(4, "Interstellar", "UFO", "Fantastic");
    private Poster five = new Poster(5, "Interstellar", "UFO", "Fantastic");
    private Poster six = new Poster(6, "Interstellar", "UFO", "Fantastic");
    private Poster seven = new Poster(7, "Interstellar", "UFO", "Fantastic");
    private Poster eight = new Poster(8, "Interstellar", "UFO", "Fantastic");
    private Poster nine = new Poster(9, "Interstellar", "UFO", "Fantastic");
    private Poster ten = new Poster(10, "Interstellar", "UFO", "Fantastic");
    private Poster eleven = new Poster(11, "Interstellar", "UFO", "Fantastic");

    public PosterManagerAddNewFilmTest() {
    }


    @BeforeEach
    public void setUp(){
      manager.add(first);
      manager.add(second);
      manager.add(third);
      manager.add(forth);
      manager.add(five);
      manager.add(six);
      manager.add(seven);
      manager.add(eight);
      manager.add(nine);
      manager.add(ten);
      manager.add(eleven);
      manager.getAll();
    }


    @Test
    public void shouldViewTenFilms() {
        Poster[] actual = new Poster[]{ten, nine, eight, seven, six, five, forth, third, second, first};
        Poster[] expected = manager.getAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    void findById() {
        int idOne = 1;
        int idTwo = 2;
        System.out.println(repository.findById(idOne));
        System.out.println(repository.findById(idTwo));


        Poster actual = repository.findById(idOne);
        Poster expected = repository.findById(idTwo);
        assertEquals(expected,actual);

    }
}

