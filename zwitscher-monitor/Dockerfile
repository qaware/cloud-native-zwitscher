FROM qaware-oss-docker-registry.bintray.io/base/alpine-k8s-ibmjava8:8.0-3.10
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-monitor

COPY build/libs/zwitscher-monitor-1.1.0.jar /opt/zwitscher-monitor/zwitscher-monitor.jar
COPY src/main/docker/zwitscher-monitor.* /opt/zwitscher-monitor/

RUN chmod 755 /opt/zwitscher-monitor/zwitscher-monitor.jar; chmod 755 /opt/zwitscher-monitor/zwitscher-monitor.sh

EXPOSE 8989
CMD /opt/zwitscher-monitor/zwitscher-monitor.sh
