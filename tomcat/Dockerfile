################################################################################
#                     Jenkins & Tomcat Docker Supercontainer                   #
################################################################################

FROM tomcat:jdk8-openjdk
MAINTAINER The TRITON Project <noreply@nowhere.com>
LABEL version="release-0.1.0" description="TRITON Tomcat Pod"

# Copy Jenkins files to contaner
COPY tomcat/container/ .

# Expose Ports
EXPOSE  8080 50000