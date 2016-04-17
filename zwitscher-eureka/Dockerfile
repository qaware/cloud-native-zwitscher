FROM qaware-oss-docker-registry.bintray.io/base/debian8-jre8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-eureka
COPY build/libs/zwitscher-eureka-1.0.0.jar /opt/zwitscher-eureka/zwitscher-eureka.jar
RUN chmod 755 /opt/zwitscher-eureka/zwitscher-eureka.jar

EXPOSE 8761
#ENTRYPOINT exec java $JAVA_OPTS -jar /opt/zwitscher-eureka/zwitscher-eureka.jar
ENTRYPOINT exec /opt/zwitscher-eureka/zwitscher-eureka.sh