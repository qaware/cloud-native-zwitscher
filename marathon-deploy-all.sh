#!/usr/bin/env bash

MARATHON_API="http://m1.dcos:8080/v2"
BASE_PATH="$(dirname "$(readlink -f "$0")")"
DELAY=30

shopt -s globstar

for f in "$BASE_PATH"/*/marathon-*.json
do
    echo "Deploying $f"
    # Deploy using the Marathon REST API
    curl -X POST "$MARATHON_API/apps" -H "Content-type: application/json" -d "@$f"
    echo
    # Wait to account for image download times
    sleep $DELAY
done
