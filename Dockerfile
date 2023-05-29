FROM openjdk:11.0.14.1-jdk

WORKDIR /opt/app

ADD target/companyclassroom-0.0.1-SNAPSHOT.jar /opt/app/companyclassroom

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","companyclassroom"]