FROM eclipse-temurin:21-jdk-jammy

WORKDIR /portfolio-website

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package install -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/portfolio-0.0.1-SNAPSHOT.jar"]
