FROM java:8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-edge
COPY build/libs/zwitscher-edge-1.0.0.jar /opt/zwitscher-edge/zwitscher-edge.jar
RUN chmod 755 /opt/zwitscher-edge/zwitscher-edge.jar

ENV JAVA_OPTS -Xmx128m -Djava.security.egd=file:/dev/./urandom

EXPOSE 8761
ENTRYPOINT exec java $JAVA_OPTS -jar /opt/zwitscher-edge/zwitscher-edge.jar
