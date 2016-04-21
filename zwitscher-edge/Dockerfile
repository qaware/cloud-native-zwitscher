FROM qaware-oss-docker-registry.bintray.io/base/debian8-jre8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-edge

COPY build/libs/zwitscher-edge-1.1.0.jar /opt/zwitscher-edge/zwitscher-edge.jar
COPY src/main/docker/zwitscher-edge.* /opt/zwitscher-edge/

RUN chmod 755 /opt/zwitscher-edge/zwitscher-edge.jar; chmod 755 /opt/zwitscher-edge/zwitscher-edge.sh

EXPOSE 8761
ENTRYPOINT exec /opt/zwitscher-edge/zwitscher-edge.sh
