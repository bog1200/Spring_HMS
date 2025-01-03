FROM eclipse-temurin:17-jre
ADD target/EUREKA_SERVER-0.0.1-SNAPSHOT.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-jar","/myapp.jar"]
