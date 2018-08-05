#!/bin/bash
cd "$(dirname $0)/server/golang"
docker run --rm -ti -v "$(pwd):/application" -v "$(pwd)/go_modules/:/go/src/" -p 8081:8081 -w /application golang:1.10.3-stretch go build -v -o server . && ./server