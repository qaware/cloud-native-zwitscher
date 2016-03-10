FROM java:8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-config
COPY build/libs/zwitscher-config-1.0.0.jar /opt/zwitscher-config/zwitscher-config.jar
RUN chmod 755 /opt/zwitscher-config/zwitscher-config.jar

ENV JAVA_OPTS -Xmx128m -Djava.security.egd=file:/dev/./urandom

EXPOSE 8888
ENTRYPOINT ["/opt/zwitscher-config/zwitscher-config.jar"]
