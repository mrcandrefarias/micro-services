FROM java:8
VOLUME /tmp
ADD . ./
RUN ./gradlew clean build
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","build/libs/apigateway-0.1.jar"]

