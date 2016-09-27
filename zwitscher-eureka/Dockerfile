FROM qaware-oss-docker-registry.bintray.io/base/alpine-k8s-ibmjava8:8.0-3.10
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-eureka

COPY build/libs/zwitscher-eureka-1.1.0.jar /opt/zwitscher-eureka/zwitscher-eureka.jar
COPY src/main/docker/zwitscher-eureka.* /opt/zwitscher-eureka/

RUN chmod 755 /opt/zwitscher-eureka/zwitscher-eureka.jar; chmod 755 /opt/zwitscher-eureka/zwitscher-eureka.sh

EXPOSE 8761
CMD /opt/zwitscher-eureka/zwitscher-eureka.sh