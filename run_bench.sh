#!/bin/bash
case "$1"
in
golang|nodejs) SERVER_VERSION=$1;;
*) echo "Usage : $0 [nodejs|golang]"; exit 1;;
esac


cd "$(dirname $0)"
"bench/gatling-charts-highcharts-bundle-2.3.1/bin/gatling.sh" -s FloodSimulation -sf "bench/simulations" -rf "reports/${SERVER_VERSION}"