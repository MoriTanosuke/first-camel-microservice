package de.kopis.microservices.services;

import java.time.LocalDate;

public class DateService {
  public LocalDate getDate() {
    return LocalDate.now();
  }
}
