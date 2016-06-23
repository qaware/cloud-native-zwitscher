#!/usr/bin/env bash

MARATHON_API="http://m1.dcos:8080/v2"
BASE_PATH="$(dirname "$0")"

find "$BASE_PATH" -depth 2 -name 'marathon-*.json' -exec curl -X POST "$MARATHON_API/apps" -H "Content-type: application/json" -d @\{\} \;