#!/bin/bash

imageId=`docker images | grep toy-component | tr -s ' ' | cut -d ' ' -f 3`

if [ ! -z "$imageId" ]; then
    docker rmi --no-prune $imageId
fi

cd /Users/pgerhard/dev/src/toy-component

sbt docker:publishLocal