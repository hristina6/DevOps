
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app


COPY pom.xml .
COPY src ./src


RUN mvn clean package -DskipTests


FROM openjdk:17-alpine


WORKDIR /app


COPY --from=build /app/target/WP-LABS2-0.0.1-SNAPSHOT.jar ./WP-LABS2.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "./WP-LABS2.jar"]
