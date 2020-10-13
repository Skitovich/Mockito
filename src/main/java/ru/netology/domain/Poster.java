package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Poster {
  private int id;
  private String name;
  private String poster;
  private String genre;


}
