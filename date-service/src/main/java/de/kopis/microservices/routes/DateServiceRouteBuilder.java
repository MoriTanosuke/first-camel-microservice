package de.kopis.microservices.routes;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;

import de.kopis.microservices.services.DateService;

public class DateServiceRouteBuilder extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("direct:getDate").setExchangePattern(ExchangePattern.InOut).bean(new DateService(), "getDate");
    // .to("direct:date");
    // add HTTP interface
    from("jetty:http://0.0.0.0:{{port}}/date").setExchangePattern(ExchangePattern.InOut).to("direct:getDate");
  }

}
