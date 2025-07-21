ARG CPUARCH=""

FROM redis:7.4.2-bookworm${CPUARCH}
LABEL maintainer="Deng Haozhi"

ENV TZ="Asia/Shanghai"
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY resource/redis.conf /usr/local/etc/redis/redis.conf

EXPOSE 12000

CMD ["redis-server", "/usr/local/etc/redis/redis.conf"]
