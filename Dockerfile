FROM openjdk:8-jre-alpine
ADD target/app.jar /home/app.jar
WORKDIR "/home"
EXPOSE 9111
CMD ["java", "-Dspring.application.name=customerapp", "-Xmx512m", "-jar", "./app.jar"]