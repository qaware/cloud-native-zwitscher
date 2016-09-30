FROM qaware-oss-docker-registry.bintray.io/base/alpine-k8s-ibmjava8:8.0-3.10
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-board

COPY build/libs/zwitscher-board-1.1.0.jar /opt/zwitscher-board/zwitscher-board.jar
COPY src/main/docker/zwitscher-board.* /opt/zwitscher-board/

RUN chmod 755 /opt/zwitscher-board/zwitscher-board.jar; chmod 755 /opt/zwitscher-board/zwitscher-board.sh

EXPOSE 8081
CMD /opt/zwitscher-board/zwitscher-board.sh
