FROM openjdk:11
VOLUME /tmp.
EXPOSE  8080
ADD     ./target/api-gateway-0.0.1-SNAPSHOT.jar "ms-product.jar"
ENTRYPOINT ["java","-jar","ms-product.jar"]