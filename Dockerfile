FROM gradle:8.14-jdk17-alpine AS build
WORKDIR /app
COPY . .
run gradle build --no-daemon

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/notificacao.jar

EXPOSE 8082

CMD ["java", "-jar", "/app/notificacao.jar"]

