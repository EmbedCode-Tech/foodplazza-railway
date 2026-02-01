# ===== STAGE 1: Build WAR =====
FROM maven:3.9.6-eclipse-temurin-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package

# ===== STAGE 2: Run on Tomcat =====
FROM tomcat:9-jdk11
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /app/target/*.war  D:\foodplazza-deploy/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
