#!/bin/bash
# 
# NAME
#        docker-entrypoint.sh - This shell script starts the Docker container
#
# SYNOPSIS
#        docker-entrypoint.sh [OPTIONS]...	
#
# DESCRIPTION
#        This script is provided as a utility to start your Docker container
#
# OPTIONS
#        start
#               Starts the Docker container processes
# BUGS
#        https://github.com/advlab/triton
#
# COPYRIGHT
#        Copyright © 2019 ServiceNow. License GPLv3+: GNU GPL
#        version 3 or later <http://gnu.org/licenses/gpl.html>.
#        This is free software: you are free to change and redistribute it.
#        There is NO WARRANTY, to the extent permitted by law.
#
################################################################################

# Set Lock
LOCKFILE=$CATALINA_HOME/configured.lock

# Local Variables
CLI_DELAY=0

log() {
  echo "[$(date --rfc-3339=seconds)]: $*"
}

configure() {

  if [ ! -e $LOCKFILE ]; then

    log "Configuring Tomcat"

    [[ -z "$TOMCAT_PASSWORD" ]] && { echo "Error: TOMCAT_PASSWORD not found"; exit 1; }
    
    # Run sed to repace Tomcat Password
    sed -i -e "s#TOMCATPASSWORD#$TOMCAT_PASSWORD#g" $CATALINA_HOME/conf/tomcat-users.xml

    # Set the lock
    touch $LOCKFILE

    log "Tomcat configured"
  else
	log "Tomcat already configured"
  fi
  return 0

}  

startall() {
	log "Starting Tomcat with a $CLI_DELAY sec delay"
	delay $CLI_DELAY
    nohup $CATALINA_HOME/bin/catalina.sh run 2>&1
}

pincontainer() {
	log "Pinning container"
	exec tail -f /dev/null
}

delay() {
  secs=$1
  shift
  msg=$@
  while [ $secs -gt 0 ]
  do
    printf "\r\033[KWaiting %.d seconds $msg" $((secs--))
    sleep 1
  done
  echo
}

usage() {
    while IFS= read -r line || [ -n "$line" ]
    do
        case "$line" in
            '#!'*) # Shebang line
                ;;
            ''|'##'*|[!#]*) # End of comments
                exit "${1:-0}"
                ;;
            *) # Comment line
                printf '%s\n' "$line" >&2 # Remove comment prefix
                ;;
        esac
    done < "$0"
}

case $1 in
start)
  configure
  startall
;; 
*)
  usage
  exit 1
esac    
exit 0