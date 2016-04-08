FROM java:8-jdk-alpine
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-service

COPY build/libs/zwitscher-service-1.0.0.jar /opt/zwitscher-service/zwitscher-service.jar

COPY src/main/docker/zwitscher-service.conf /opt/zwitscher-service/
COPY src/main/docker/zwitscher-service.sh /opt/zwitscher-service/

RUN chmod 755 /opt/zwitscher-service/zwitscher-service.jar
RUN chmod 755 /opt/zwitscher-service/zwitscher-service.sh

EXPOSE 8761
ENTRYPOINT exec /opt/zwitscher-service/zwitscher-service.sh
