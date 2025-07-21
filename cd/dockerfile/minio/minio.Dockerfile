ARG CPUARCH=""

FROM bitnami/minio:2024.12.18-debian-12-r0${CPUARCH}
LABEL maintainer="Deng Haozhi"

USER root
RUN chown -R 11000:11000 /bitnami/minio/data
RUN chmod -R 755 /bitnami/minio/data
USER 11000

WORKDIR /bitnami/minio

ENV MINIO_API_PORT_NUMBER=11000
ENV MINIO_CONSOLE_PORT_NUMBER=11001

EXPOSE 11000 11001
