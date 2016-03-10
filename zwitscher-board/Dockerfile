FROM java:8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-board
COPY build/libs/zwitscher-board-1.0.0.jar /opt/zwitscher-board/zwitscher-board.jar
RUN chmod 755 /opt/zwitscher-board/zwitscher-board.jar

ENV JAVA_OPTS -Xmx128m -Djava.security.egd=file:/dev/./urandom

EXPOSE 8081
ENTRYPOINT exec java $JAVA_OPTS -jar /opt/zwitscher-board/zwitscher-board.jar
