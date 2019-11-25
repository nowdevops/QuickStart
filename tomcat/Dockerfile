################################################################################
#                                 Tomcat Container                             #
################################################################################

FROM tomcat:jdk8-openjdk
MAINTAINER The TRITON Project <noreply@nowhere.com>
LABEL version="release-0.1.0" description="TRITON Tomcat Pod"

# Declare the default shell
SHELL ["/bin/bash", "-c"]

# Install Toos
RUN \
  apt-get -qq update && \
  apt-get -y install bash-completion

# Default to UTF-8 file.encoding
ENV LC_ALL en_US.UTF-8

# Copy Jenkins files to contaner
COPY tomcat/container/ /

# Expose Ports
EXPOSE 8080