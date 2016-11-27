FROM million12/varnish

COPY ./conf/skills.vcl /etc/varnish/skills.vcl

ENV VCL_CONFIG      /etc/varnish/skills.vcl
ENV CACHE_SIZE      64m
ENV VARNISHD_PARAMS -p default_ttl=3600 -p default_grace=3600

EXPOSE 80
CMD /start.sh
