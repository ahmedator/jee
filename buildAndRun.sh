#!/bin/sh
mvn clean package && docker build -t com.efficom.tpfinal/tpfinal .
docker rm -f tpfinal || true && docker run -d -p 9080:9080 -p 9443:9443 --name tpfinal com.efficom.tpfinal/tpfinal