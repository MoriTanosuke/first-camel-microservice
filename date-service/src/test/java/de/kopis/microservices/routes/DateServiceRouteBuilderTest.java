package de.kopis.microservices.routes;

import java.time.LocalDate;

import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateServiceRouteBuilderTest extends CamelTestSupport {
  @Produce(uri = "direct:getDate")
  private ProducerTemplate start;

  @BeforeClass
  public static void setJettyPort() {
    System.setProperty("port", "2345");
  }

  @Test
  public void canGetDateFromRoute() throws InterruptedException {

    Exchange exchange = createExchangeWithBody("not relevant");
    start.send(exchange);

    Object date = exchange.getOut().getBody();
    assertEquals(LocalDate.class, date.getClass());
  }

  @Override
  protected RouteBuilder[] createRouteBuilders() throws Exception {
    return new RouteBuilder[] { new DateServiceRouteBuilder(), new RouteBuilder() {
      @Override
      public void configure() throws Exception {
        from("direct:date").to("mock:result");
      }
    } };
  }

}
