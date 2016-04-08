FROM java:8-jdk-alpine
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-board

COPY build/libs/zwitscher-board-1.0.0.jar /opt/zwitscher-board/zwitscher-board.jar

COPY src/main/docker/zwitscher-board.conf /opt/zwitscher-board/
COPY src/main/docker/zwitscher-board.sh /opt/zwitscher-board/

RUN chmod 755 /opt/zwitscher-board/zwitscher-board.jar
RUN chmod 755 /opt/zwitscher-board/zwitscher-board.sh

EXPOSE 8081
ENTRYPOINT exec /opt/zwitscher-board/zwitscher-board.sh
