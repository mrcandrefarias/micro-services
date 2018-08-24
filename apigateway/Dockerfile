FROM java:8
VOLUME /tmp
ADD . ./
RUN sh build.sh
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","apigateway-0.1.jar"]

