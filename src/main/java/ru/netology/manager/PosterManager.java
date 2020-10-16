package ru.netology.manager;


import lombok.NoArgsConstructor;
import ru.netology.domain.Poster;

@NoArgsConstructor

public class PosterManager {
    private int afishaLength = 10;
    private Poster[] films = new Poster[0];

    public PosterManager(int afishaLength) {
        this.afishaLength = afishaLength;
    }

    public void add(Poster film) {
        int length = films.length + 1;
        Poster[] tmp = new Poster[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Poster[] getAll() {

        int getAllLength;
        getAllLength = Math.min(afishaLength, films.length);
        Poster[] result = new Poster[getAllLength];
        for (int i = 0; i < getAllLength; i++) {
            int index = films.length - 1 - i;
            result[i] = films[index];
        }
        return result;
    }
}


