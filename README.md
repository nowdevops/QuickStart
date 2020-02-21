![Intro](./docs/triton-mosaic.jpg)

QuickStart CI/CD Deployment Template for a pre-configured Jenkins Pod. Later we will add an Atlassian JIRA Pod as well as ServiceNow New York Pods to complete the CI/CD Devops experience. Stay tuned.

# Prerequisites

* OKD Cluster Admin Access

# Installation

Installing QuickStart consists of setting the OpenShift Cluster namespace

## Creating QuickStart Namespace

Before you can deploy QuickStart Containers the OKD administrator needs to perfom the initial configuration of a namespace and install the supporting templates and images as follows:

* [Creating QuickStart Namespace](./docs/QuickStartNamespace.md)

## Creating QuickStart Containers

Creating QuickStart containers is easy and it consists of running a QuickStart template from the Catalog and providing a couple of parameters before kicking it off as follows:

* [Creating QuickStart Containers](./docs/QuickStartContainers.md)