#!/bin/sh

SERVICE_NAME=${1}
PATH_TO_JAR=${2}

mkdir /apps/${SERVICE_NAME}/
PID_PATH_NAME=/apps/${SERVICE_NAME}/.pid

case ${3} in
    start)
        echo "Starting $SERVICE_NAME ..."
        if [ ! -f $PID_PATH_NAME ]; then
            nohup java -jar $PATH_TO_JAR --spring.profiles.active=prod 2>> /apps/${SERVICE_NAME}/${SERVICE_NAME}.err >> /apps/${SERVICE_NAME}/${SERVICE_NAME}.log &
            echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is already running ..."
        fi
    ;;
    stop)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stoping ..."
            kill $PID;
            echo "$SERVICE_NAME stopped ..."
            rm $PID_PATH_NAME
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
    restart)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stopping ...";
            kill $PID;
            echo "$SERVICE_NAME stopped ...";
            rm $PID_PATH_NAME
        else
            echo "$SERVICE_NAME is not running ..."
        fi

	echo "$SERVICE_NAME starting ..."
        nohup java -jar $PATH_TO_JAR --spring.profiles.active=prod 2>> /apps/${SERVICE_NAME}/${SERVICE_NAME}.err >> /apps/${SERVICE_NAME}/${SERVICE_NAME}.log &
        echo $! > $PID_PATH_NAME
        echo "$SERVICE_NAME started ..."
    ;;
esac
