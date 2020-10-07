package ru.netology.manager;

import ru.netology.domain.Poster;
import ru.netology.repository.PosterRepository;


public class PosterManager {
    private PosterRepository repository;

    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }

    public void add(Poster item) {
        repository.save(item);
    }

    public Poster[] getAll() {
        Poster[] films = repository.findAll();
        Poster[] result = new Poster[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public void removeById (int id) {
        repository.removeById(id);
    }


}

