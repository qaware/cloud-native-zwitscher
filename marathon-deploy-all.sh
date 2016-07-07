#!/usr/bin/env bash

MARATHON_API="http://m1.dcos:8080/v2"
BASE_PATH="$(dirname "$0")"

shopt -s globstar

for f in "$BASE_PATH"/*/marathon-*.json
do
    echo "Deploying $f"
    curl -X POST "$MARATHON_API/apps" -H "Content-type: application/json" -d "@$f"
    echo
    sleep 5
done
