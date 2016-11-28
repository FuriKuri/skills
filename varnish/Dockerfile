FROM million12/varnish

COPY ./conf/skills.vcl /etc/varnish/skills.vcl

ENV VCL_CONFIG      /etc/varnish/skills.vcl
ENV CACHE_SIZE      64m
ENV VARNISHD_PARAMS -p default_ttl=300 -p default_grace=300

EXPOSE 80
CMD /start.sh
