FROM qaware-oss-docker-registry.bintray.io/base/alpine-k8s-openjdk8:8u92
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-config

COPY build/libs/zwitscher-config-1.1.0.jar /opt/zwitscher-config/zwitscher-config.jar
COPY src/main/docker/zwitscher-config.* /opt/zwitscher-config/

RUN chmod 755 /opt/zwitscher-config/zwitscher-config.jar; chmod 755 /opt/zwitscher-config/zwitscher-config.sh

RUN rm -f /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/local_policy.jar /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/US_export_policy.jar
ADD src/main/docker/jce_policy-8.tar.gz /usr/lib/jvm/java-1.8-openjdk/jre/lib/security

EXPOSE 8888
CMD /opt/zwitscher-config/zwitscher-config.sh
