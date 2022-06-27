@echo off
call mvn clean package
call docker build -t com.efficom.tpfinal/tpfinal .
call docker rm -f tpfinal
call docker run -d -p 9080:9080 -p 9443:9443 --name tpfinal com.efficom.tpfinal/tpfinal