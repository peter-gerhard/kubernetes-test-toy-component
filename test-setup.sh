#!/bin/bash

containerId=`docker run -d -p 8080 toy-component:0.0.1-SNAPSHOT`

sleep 2

resp=`curl -s -S http://localhost:8080/`

echo $resp

docker rm -vf $containerId > /dev/null