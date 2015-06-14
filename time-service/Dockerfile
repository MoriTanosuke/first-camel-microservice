FROM ubuntu:14.04

# Prerequisites.

RUN apt-get -y update
RUN apt-get -y install wget tar

# Oracle Java 7

WORKDIR /opt

#RUN wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/7u71-b14/server-jre-7u71-linux-x64.tar.gz
RUN wget -q --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u45-b14/jdk-8u45-linux-x64.tar.gz
RUN tar xzf jdk-8u45-linux-x64.tar.gz
RUN rm -rf jdk-8u45-linux-x64.tar.gz
RUN ls -la
RUN update-alternatives --install /usr/bin/java java /opt/jdk1.8.0_45/bin/java 1

# App

USER daemon

# This copies to local fat jar inside the image
ADD target/time-service*.jar /opt/timeservice.jar

# What to run when the container starts
ENTRYPOINT [ "java", "-jar", "/opt/timeservice.jar", "5000" ]

# Ports used by the app
EXPOSE 5000
