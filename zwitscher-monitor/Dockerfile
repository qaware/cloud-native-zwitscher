FROM qaware-oss-docker-registry.bintray.io/base/debian8-jre8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-monitor

COPY build/libs/zwitscher-monitor-1.0.0.jar /opt/zwitscher-monitor/zwitscher-monitor.jar
COPY src/main/docker/zwitscher-monitor.* /opt/zwitscher-monitor/

RUN chmod 755 /opt/zwitscher-monitor/zwitscher-monitor.jar; chmod 755 /opt/zwitscher-monitor/zwitscher-monitor.sh

EXPOSE 8761
ENTRYPOINT exec /opt/zwitscher-monitor/zwitscher-monitor.sh
