[![Build Status](https://travis-ci.org/MoriTanosuke/first-camel-microservice.svg?branch=master)](https://travis-ci.org/MoriTanosuke/first-camel-microservice)

What is this madness?
=====================

This is my first approach to build microservices based on [Java 8][0], [Apache Maven][1] and [Apache Camel][2]. The technology itself is not the bleeding edge [Scala][3] or [Clojure][4] stuff that you might expect, but it is tried-and-proven technology that is being used a lot in production systems already. I think it would be nice to use this stable (boring?) stuff to build something new, like microservices being run in [Docker][5] containers.

How do I run this example?
--------------------------

*Run with Maven and Java*

You can run this example applications like any other Maven project. First, build the whole project by executing the following command in the top directory:

    mvn clean package

After that you can start the 2 services, *date-service* and *time-service* with pure Java:

    java -jar time-service/target/timeservice-*.jar 5678
    java -jar date-service/target/dateservice-*.jar 5679

When everything runs fine and there are no *ERROR*s in your console output, open [http://localhost:5678/time][10] or [http://localhost:5679/date][11] to see the output of the services.

*Run with Docker*

You have to build the project with Maven first. Then you can use *docker-compose* to start the services. Run the following comand in the top directory:

    docker-compose up

After that you can open [http://localhost:8081/time][12] or [http://localhost:8080/date][13] to see the output of the services. If those ports are not free at your machine, you have to edit the Dockerfiles.

[0]: http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html
[1]: https://maven.apache.org/
[2]: https://camel.apache.org/
[3]: http://www.scala-lang.org/
[4]: http://clojure.org/
[5]: https://www.docker.com/
[10]: http://localhost:5678/time
[11]: http://localhost:5679/date
[12]: http://localhost:8081/time
[13]: http://localhost:8080/date
