package ru.netology.manager;

import ru.netology.domain.Poster;
import ru.netology.repository.PosterRepository;

public class PosterManager {

    private PosterRepository repository;
    private int afishaLength = 10;

    public PosterManager(PosterRepository repository, int afishaLength) {
        this.repository = repository;
        this.afishaLength = afishaLength;
    }

    public PosterManager() {
    }

    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void add(Poster item) {
        repository.save(item);
    }


    public Poster[] getAll() {
        Poster[] films = repository.findAll();
        int getAllLength = Math.min(afishaLength, films.length);
        Poster[] result = new Poster[getAllLength];
        for (int i = 0; i < getAllLength; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }


}

