#!/bin/sh
export KUBERNETES_PROVIDER=vagrant
export NUM_NODES=1

# export KUBERNETES_MEMORY=2048
# export KUBERNETES_MASTER_MEMORY=1536
# export KUBERNETES_NODE_MEMORY=2048

export KUBE_ENABLE_CLUSTER_MONITORING=none

curl -sS https://get.k8s.io | bash
