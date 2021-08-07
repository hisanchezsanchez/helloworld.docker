FROM adoptopenjdk:11
ENV FIREBASE_USER=""
ENV FIREBASE_PWD=""
COPY build/libs/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
