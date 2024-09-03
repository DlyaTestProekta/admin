FROM openjdk:21

COPY build/libs/admin.jar /admin.jar

ENTRYPOINT ["java", "-jar", "/admin.jar"]
