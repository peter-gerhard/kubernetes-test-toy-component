#!/usr/bin/env bash

set -o errexit # exit immediately on error
set -o nounset # raise error if variable is unset


SERVICE_ACC_KEY_FILE="deployment-service-acc.json"
HELM_VALUES_PATH="helm/${BUILD_ENVIRONMENT}"

## Prepare credentials

echo ${GOOGLE_CLOUD_KMS_SERVICE_ACC} | base64 --decode > SERVICE_ACC_KEY_FILE
gcloud auth activate-service-account --key-file SERVICE_ACC_KEY_FILE
gcloud container clusters get-credentials ${KUBERNETES_CLUSTER_NAME} --zone ${KUBERNETES_CLUSTER_ZONE} --project ${GOOGLE_CLOUD_PROJECT_NAME}

gcloud kms decrypt \
  --project=${GOOGLE_CLOUD_PROJECT_NAME} \
  --location=${GOOGLE_CLOUD_KMS_KEY_RING_LOCATION} \
  --keyring=${GOOGLE_CLOUD_KMS_KEY_RING} \
  --key=${GOOGLE_CLOUD_KMS_KEY} \
  --plaintext-file=${HELM_VALUES_PATH}/secrets.yaml \
  --ciphertext-file=${HELM_VALUES_PATH}/secrets.enc







## Create a new release (helm terms) ?
## Generate a new kubernetes manifest / pod specification (kubernetes terms) ?

helm upgrade \
  --install \
  --wait \
  --namespace ${KUBERNETES_CLUSTER_NAMESPACE} \
  -f ${HELM_VALUES_PATH}/values.yaml \
  -f ${HELM_VALUES_PATH}/secrets.yaml \
  --set image.tag=${ARTIFACT_VERSION} \
  ${APPLICATION_NAME} helm/toy-component-chart