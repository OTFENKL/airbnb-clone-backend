#!/bin/bash

if [ $(is_healthy) -eq 1 ]; then
    kill -15 ${APPLICATION_PID}
fi