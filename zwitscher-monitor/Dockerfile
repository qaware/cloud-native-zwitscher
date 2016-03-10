FROM java:8
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /opt/zwitscher-monitor
COPY build/libs/zwitscher-monitor-1.0.0.jar /opt/zwitscher-monitor/zwitscher-monitor.jar
RUN chmod 755 /opt/zwitscher-monitor/zwitscher-monitor.jar

ENV JAVA_OPTS -Xmx128m -Djava.security.egd=file:/dev/./urandom

EXPOSE 8761
ENTRYPOINT exec java $JAVA_OPTS -jar /opt/zwitscher-monitor/zwitscher-monitor.jar
