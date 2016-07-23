#!/usr/bin/env bash
# Deploys all Zwitscher services on DC/OS in one go.

# Location of the marathon API.
# http://m1.dcos:8080/v2 for Vagrant DC/OS cluster.
MARATHON_API="http://m1.dcos:8080/v2"
# Delay between deployments to account for image download and startup times
DELAY=45
# Service start order
START_ORDER="eureka config service board edge monitor"

# Determine the base path
BASE_PATH="$(dirname "$0")"

# Workaround for OSX not having readlink -f to resolve symlinks
if uname | grep "Darwin" > /dev/null
then
  while [ -L "$BASE_PATH" ]
  do
      BASE_PATH="$(readlink "$BASE_PATH")"
  done
else
  BASE_PATH="$(readlink -f "$BASE_PATH")"
fi

# Hard-coded service start order
for SERVICE in $START_ORDER
do
  f="$BASE_PATH/zwitscher-$SERVICE/marathon-zwitscher-$SERVICE.json"
    echo "Deploying $f"
    # Deploy using the Marathon REST API
    curl -X POST "$MARATHON_API/apps" -H "Content-type: application/json" -d "@$f"
    echo
    sleep $DELAY
done
