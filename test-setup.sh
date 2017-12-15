#!/bin/bash

containerId=`docker run --rm -d -p 8080:8080 toy-component:0.0.1-SNAPSHOT`

sleep 1

n=0
until [ $n -ge 10 ]
do

  curl -s -S http://localhost:8080/
  status=$?

  if [ ! $status -eq 52 ]; then break; fi

  sleep 1
  n=$[$n+1]
done

docker rm -vf $containerId > /dev/null