FROM docker-base-repo.idomsoft.hu/java/openjdk/17/alpine:3.17.2-jdk17.0.6_10

WORKDIR /usr/local

RUN apk add --no-cache curl wget vim less jq && rm -rf /var/cache/apk/*

ADD build/libs/timeouttest-0.0.1-SNAPSHOT.jar /usr/local/app.jar
CMD [ "sh", "-c", "java -XX:-UsePerfData -Dfile.encoding=UTF-8 $JAVA_OPTS -jar /usr/local/app.jar" ]