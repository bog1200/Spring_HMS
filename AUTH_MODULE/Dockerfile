FROM eclipse-temurin:17-jre
ADD target/AUTH_MODULE-0.0.1-SNAPSHOT.jar myapp.jar
ADD .env .env
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-jar","/myapp.jar"]
