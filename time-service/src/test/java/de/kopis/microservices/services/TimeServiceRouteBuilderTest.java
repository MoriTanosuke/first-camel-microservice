package de.kopis.microservices.services;

import java.time.LocalTime;

import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.BeforeClass;
import org.junit.Test;

public class TimeServiceRouteBuilderTest extends CamelTestSupport {
  @Produce(uri = "direct:getTime")
  private ProducerTemplate start;

  @BeforeClass
  public static void setJettyPort() {
    System.setProperty("port", "2345");
  }

  @Test
  public void canGetTimeFromRoute() throws InterruptedException {
    Exchange exchange = createExchangeWithBody("not relevant here");
    start.send(exchange);

    Object time = exchange.getOut().getBody();
    assertEquals(LocalTime.class, time.getClass());
  }

  @Override
  protected RouteBuilder[] createRouteBuilders() throws Exception {
    return new RouteBuilder[] { new TimeServiceRouteBuilder(), new RouteBuilder() {
      @Override
      public void configure() throws Exception {
        from("direct:time").to("mock:result");
      }
    } };
  }

}
