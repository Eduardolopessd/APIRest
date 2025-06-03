# Estágio de build otimizado
FROM maven:3.9.7-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
# Cache de dependências
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio final seguro
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /app/target/pedido-api.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]