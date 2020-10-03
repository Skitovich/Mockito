package ru.netology.manager;

import ru.netology.domain.Poster;


public class PosterManager {
    private Poster[] films = new Poster[0];

    public void add (Poster film) {
        int length = films.length + 1;
        Poster[] tmp = new Poster[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Poster[] getAll() {
        Poster[] result = new Poster[10];
        for (int i = 0; i < result.length; i++) {
            int index = result.length - 1 - i;
            result[i] = films[index];
        }
        return result;
    }
}


