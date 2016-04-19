#!/bin/sh
export KUBERNETES_PROVIDER=aws

# Frankfurt
export KUBE_AWS_ZONE=eu-central-1a
export NUM_NODES=4
export MASTER_SIZE=m3.medium
export NODE_SIZE=t2.small
export KUBE_AWS_INSTANCE_PREFIX=k8s

# Disable logging to save resources
export KUBE_ENABLE_CLUSTER_MONITORING=none
export KUBE_ENABLE_NODE_LOGGING=false
export KUBE_ENABLE_CLUSTER_LOGGING=false

export KUBE_ENABLE_NODE_AUTOSCALER=true
export KUBE_AUTOSCALER_MIN_NODES=2
export KUBE_AUTOSCALER_MAX_NODES=4

curl -sS https://get.k8s.io | bash
