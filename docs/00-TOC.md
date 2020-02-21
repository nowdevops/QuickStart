---
title: QuickStart for ServiceNow Devops (triton)
author: ITx Emerging Solutions
date: 2/21/2020
---

# Prerequisites

* OKD Cluster Admin Access
* ServiceNow HI Portal Access

# Installation

Installing QuickStart consists of initially setting the OpenShift Cluster namespace and allowing users to create their own QuickStart containers using the Catalog to kick off templated container deployments.

## Creating QuickStart Namespace

Before you can deploy QuickStart Containers the OKD administrator needs to perfom the initial configuration of a namespace and install the supporting templates and images as follows:

* [Creating QuickStart Namespace](./docs/QuickStartNamespace.md)

## Creating QuickStart Containers

Creating QuickStart containers is easy and it consists of running a QuickStart template from the Catalog and providing a couple of parameters before kicking it off as follows:

* [Creating QuickStart Containers](./docs/QuickStartContainers.md)

## Creating ServiceNow Instance

When using QuickStart containers you will need to create a ServiceNow instance and configure it for DevOps integrations with the QuickStart containers as follows:

* [Creating ServiceNow Instance](./docs/ServiceNowInstance.md)

