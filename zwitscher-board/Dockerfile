FROM qaware-oss-docker-registry.bintray.io/base/debian8-jre8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-board

COPY build/libs/zwitscher-board-1.1.0.jar /opt/zwitscher-board/zwitscher-board.jar
COPY src/main/docker/zwitscher-board.* /opt/zwitscher-board/

RUN chmod 755 /opt/zwitscher-board/zwitscher-board.jar; chmod 755 /opt/zwitscher-board/zwitscher-board.sh

EXPOSE 8081
ENTRYPOINT exec /opt/zwitscher-board/zwitscher-board.sh
