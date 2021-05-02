#!/usr/bin/env bash

SCRIPT_PATH="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
PROJECT_PATH=${SCRIPT_PATH}/..

cd "${PROJECT_PATH}" || exit

rm -rf "${PROJECT_PATH}"/target

./mvnw clean install

cd "${PROJECT_PATH}"/src/main/docker || exit

docker-compose up --build -d
