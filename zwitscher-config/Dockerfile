FROM qaware-oss-docker-registry.bintray.io/base/debian8-jre8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-config

COPY build/libs/zwitscher-config-1.0.0.jar /opt/zwitscher-config/zwitscher-config.jar

COPY src/main/docker/zwitscher-config.conf /opt/zwitscher-config/
COPY src/main/docker/zwitscher-config.sh /opt/zwitscher-config/

RUN chmod 755 /opt/zwitscher-config/zwitscher-config.jar
RUN chmod 755 /opt/zwitscher-config/zwitscher-config.sh

ADD src/main/docker/jce_policy-8.tar.gz $JAVA_HOME/jre/lib/security

EXPOSE 8888
ENTRYPOINT exec /opt/zwitscher-config/zwitscher-config.sh
