FROM qaware-oss-docker-registry.bintray.io/base/debian8-jre8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-config

COPY build/libs/zwitscher-config-1.0.0.jar /opt/zwitscher-config/zwitscher-config.jar
COPY src/main/docker/zwitscher-config.* /opt/zwitscher-config/

RUN chmod 755 /opt/zwitscher-config/zwitscher-config.jar; chmod 755 /opt/zwitscher-config/zwitscher-config.sh

RUN rm -f /opt/java/latest/jre/lib/security/local_policy.jar /opt/java/latest/jre/lib/security/US_export_policy.jar
ADD src/main/docker/jce_policy-8.tar.gz /opt/java/latest/jre/lib/security

EXPOSE 8888
ENTRYPOINT exec /opt/zwitscher-config/zwitscher-config.sh
