FROM azul/zulu-openjdk-alpine:11-jre
COPY target/office-app.jar /opt
ENV PERSISTENCE_UNIT=office
ENTRYPOINT ["java", "-jar", "/opt/office-app.jar"]