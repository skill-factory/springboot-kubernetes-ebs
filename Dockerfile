FROM kalyancherukuru/alpine-java:latest

WORKDIR /app

COPY target/employ-myql.jar ./

EXPOSE 8080

ENTRYPOINT ["java","-jar","employ-myql.jar"]