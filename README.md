# skills

## Preparation

```
docker run -d --name mongo -p 27017:27017 mongo
docker run -d --hostname my-rabbit -p 15672:15672 -p 5672:5672 --name rabbitmq -e RABBITMQ_DEFAULT_USER=test -e RABBITMQ_DEFAULT_PASS=password rabbitmq:3-management
docker run --name elasticsearch -p 9200:9200 -p 9300:9300 -d elasticsearch
```
