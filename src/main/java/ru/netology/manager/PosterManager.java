package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Poster;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PosterManager {
    private Poster[] films = new Poster[0];
    int afishaLength = 10;

    public PosterManager(int i) {
    setAfishaLength(i);
    }



    public void add (Poster film) {
        int length = films.length + 1;
        Poster[] tmp = new Poster[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Poster[] getAll() {

        int getAllLength = 0;
        getAllLength = Math.min(afishaLength, films.length);
        Poster[] result = new Poster[getAllLength];
        for (int i = 0; i < result.length; i++) {
            int index = result.length - 1 - i;
            result[i] = films[index];
        }
        return result;
    }
}


