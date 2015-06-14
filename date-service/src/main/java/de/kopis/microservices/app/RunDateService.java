package de.kopis.microservices.app;

import org.apache.camel.main.Main;

import de.kopis.microservices.routes.DateServiceRouteBuilder;

public class RunDateService {

  private Main main;

  public static void main(String[] args) throws Exception {
    RunDateService app = new RunDateService();
    final String port = (args.length == 1 ? args[0] : "8765");
    app.boot(port);
  }

  public void boot(String port) throws Exception {
    System.setProperty("port", port);

    // create a Main instance
    main = new Main();
    // enable hangup support so you can press ctrl + c to terminate the JVM
    main.enableHangupSupport();
    // add routes
    main.addRouteBuilder(new DateServiceRouteBuilder());

    // run until you terminate the JVM
    System.out.println(String.format("Starting Camel, using port %s. Use ctrl + c to terminate the JVM.", port));
    main.run();
  }
}
