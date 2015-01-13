# streams-playground #

A Playground for [Akka-Streams](http://doc.akka.io/docs/akka-stream-and-http-experimental/1.0-M2/index.html). 

## Setup

You'll need a running [RabbitMq](http://www.rabbitmq.com) server. The simplest way is
to launch a docker container:

```
docker run --name rmq -p 15672:15672 -p 5672:5672 dockerfile/rabbitmq
```

Then tweak the ```reference.conf``` file to point to your docker host. (I have an
```/etc/hosts``` entry that points my docker host's ip to the docker alias).

## Notes

I dislike the maven directory layout, and prefer Go's simplified path model with tests next to classes. This project modifies build.sbt to search for source files in different places than the default.
