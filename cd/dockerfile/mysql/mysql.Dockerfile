ARG CPUARCH=""

FROM mysql:lts-oraclelinux9${CPUARCH}
LABEL maintainer="Deng Haozhi"

ENV TZ="Asia/Shanghai"
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY resource/my.cnf /etc/mysql/conf.d/my.cnf

USER root
RUN mkdir -p /var/log/mysql && \
    groupmod -g 13000 mysql && \
    usermod -u 13000 -g mysql mysql && \
    chown -R mysql:mysql /var/log/mysql && \
    chmod -R 755 /var/log/mysql && \
    chown -R mysql:mysql /var/lib/mysql && \
    chmod -R 755 /var/lib/mysql && \
    chown -R mysql:mysql /etc/mysql/conf.d && \
    chmod -R 755 /etc/mysql/conf.d
USER mysql

EXPOSE 13000

CMD [ "mysqld" ]
