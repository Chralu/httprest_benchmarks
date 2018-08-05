#!/bin/bash
cd "$(dirname $0)/server/nodejs"
docker run --rm -ti -v "$(pwd):/application" -p 8081:8081 -w /application --env NODE_ENV=production node:10-alpine npm install && npm start