FROM java:8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-service
COPY build/libs/zwitscher-service-1.0.0.jar /opt/zwitscher-service/zwitscher-service.jar
RUN chmod 755 /opt/zwitscher-service/zwitscher-service.jar

ENV JAVA_OPTS -Xmx128m -Djava.security.egd=file:/dev/./urandom

EXPOSE 8761
ENTRYPOINT exec java $JAVA_OPTS -jar /opt/zwitscher-service/zwitscher-service.jar
