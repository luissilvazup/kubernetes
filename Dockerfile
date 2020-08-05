FROM openjdk:14-jdk
ENV APP_TARGET target
ENV APP kubernetes-application.jar

RUN mkdir -p /opt
COPY ./${APP_TARGET}/${APP} /opt

CMD java -jar /opt/${APP}