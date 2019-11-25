################################################################################
#                                 Tomcat Container                             #
################################################################################

FROM tomcat:jdk8-openjdk
MAINTAINER The TRITON Project <noreply@nowhere.com>
LABEL version="release-0.1.0" description="TRITON Tomcat Pod"

# Declare the default shell
SHELL ["/bin/bash", "-c"]

# Copy Jenkins files to container
COPY tomcat/config/ /

# Expose Ports
EXPOSE 8080

# Configure Docker entry point script
CMD ["docker-entrypoint.sh","start"]