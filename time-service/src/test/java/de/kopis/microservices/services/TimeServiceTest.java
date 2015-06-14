package de.kopis.microservices.services;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

public class TimeServiceTest {

  @Test
  public void canGetTime() {
    Object time = new TimeService().getTime();
    assertEquals(LocalTime.class, time.getClass());
  }

}
