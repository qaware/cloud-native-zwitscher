#!/bin/sh

export KUBE_GCE_ZONE=europe-west1-d
export NUM_NODES=4
export KUBE_GCE_INSTANCE_PREFIX=k8s

# Disable logging to save resources
export KUBE_ENABLE_CLUSTER_MONITORING=none
export KUBE_ENABLE_NODE_LOGGING=false
export KUBE_ENABLE_CLUSTER_LOGGING=false

#export KUBE_ENABLE_NODE_AUTOSCALER=true
#export KUBE_AUTOSCALER_MIN_NODES=2
#export KUBE_AUTOSCALER_MAX_NODES=4

curl -sS https://get.k8s.io | bash
