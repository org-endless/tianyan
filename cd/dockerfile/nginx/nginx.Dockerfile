ARG CPUARCH=""

FROM nginx:1.27.3-bookworm${CPUARCH}
LABEL maintainer="Deng Haozhi"

ENV TZ="Asia/Shanghai"
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY resource/nginx.conf /etc/nginx/nginx.conf
COPY resource/gycdp.crt /etc/nginx/ssl/gycdp.crt
COPY resource/gycdp.key /etc/nginx/ssl/gycdp.key

EXPOSE 443

CMD [ "/bin/sh", "-c", "ulimit -n 65536 && ulimit -s 16384 && nginx -g 'daemon off;'" ]
