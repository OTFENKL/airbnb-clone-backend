#!/bin/bash

APPLICATION_NAME=$(ls ${BASE_DIR} | grep .jar)
APPLICATION_PID=$(pgrep -f $APPLICATION_NAME)
