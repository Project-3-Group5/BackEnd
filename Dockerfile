# ---- build stage ----
FROM gradle:9.4.1-jdk21 AS build
WORKDIR /src
COPY . .
RUN gradle bootJar --no-daemon -x test --stacktrace

# ---- runtime stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /src/build/libs/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]