#!/bin/bash

function is_healthy() {
    if [ -z ${APPLICATION_PID} ]; then
        echo 0
    else
        echo 1
    fi
}