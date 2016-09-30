FROM qaware-oss-docker-registry.bintray.io/base/alpine-k8s-ibmjava8:8.0-3.10
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-edge

COPY build/libs/zwitscher-edge-1.1.0.jar /opt/zwitscher-edge/zwitscher-edge.jar
COPY src/main/docker/zwitscher-edge.* /opt/zwitscher-edge/

RUN chmod 755 /opt/zwitscher-edge/zwitscher-edge.jar; chmod 755 /opt/zwitscher-edge/zwitscher-edge.sh

EXPOSE 8765
CMD /opt/zwitscher-edge/zwitscher-edge.sh
