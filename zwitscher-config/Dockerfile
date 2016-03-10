FROM java:8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-config
COPY build/libs/zwitscher-config-1.0.0.jar /opt/zwitscher-config/zwitscher-config.jar
RUN chmod 755 /opt/zwitscher-config/zwitscher-config.jar

ADD src/main/docker/jce_policy-8.tar.gz $JAVA_HOME/jre/lib/security

ENV JAVA_OPTS -Xmx128m -Djava.security.egd=file:/dev/./urandom

EXPOSE 8888
ENTRYPOINT exec java $JAVA_OPTS -jar /opt/zwitscher-config/zwitscher-config.jar
