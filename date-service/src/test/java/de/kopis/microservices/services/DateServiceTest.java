package de.kopis.microservices.services;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import de.kopis.microservices.services.DateService;

public class DateServiceTest {

  @Test
  public void test() {
    LocalDate date = new DateService().getDate();
    assertEquals(LocalDate.class, date.getClass());
  }

}
