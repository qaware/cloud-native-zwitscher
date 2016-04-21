FROM qaware-oss-docker-registry.bintray.io/base/debian8-jre8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-service

COPY build/libs/zwitscher-service-1.1.0.jar /opt/zwitscher-service/zwitscher-service.jar
COPY src/main/docker/zwitscher-service.* /opt/zwitscher-service/

RUN chmod 755 /opt/zwitscher-service/zwitscher-service.jar; chmod 755 /opt/zwitscher-service/zwitscher-service.sh

EXPOSE 8761
ENTRYPOINT exec /opt/zwitscher-service/zwitscher-service.sh
