################################################################################
#                                 Tomcat Container                             #
################################################################################

FROM tomcat:jdk8-openjdk
LABEL maintainer="TRITON <ITX-NOW@servicenow.onmicrosoft.com>"

# Declare the default shell
SHELL ["/bin/bash", "-c"]

# Copy Jenkins files to container
COPY tomcat/config/ /

# Expose Ports
EXPOSE 8080

# Configure Docker entry point script
CMD ["docker-entrypoint.sh","start"]