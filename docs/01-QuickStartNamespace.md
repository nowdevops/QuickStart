# Creating QuickStart Containers

1. Login to [OKD](https://openshift.sytes.net:8443) as Cluster Administrator

1. Create Namespace (e.g. `triton`)

    ```
    oc create namespace triton
    oc project triton
    ```
1. Create Service Account

    ```
    oc create serviceaccount triton
    ```

1. Grant rights to Service Account

    ```
    oc adm policy add-scc-to-user anyuid -z triton -n triton
    ```

1. Clone Project

    ```
    git clone git@github.com:advlab/triton.git
    cd triton
    ```

1. Create Git Key

    ```
    ssh-keygen -t rsa -b 4096 -C "triton@noreply.com" -f $HOME/.ssh/triton
    ```

1. Configure [GitHub Project](https://github.com/advlab/triton) Deploy Key using the Git Key from above

1. Create GitHub Secret

    ```
    oc create secret generic github-triton --type=kubernetes.io/ssh-auth --from-file=ssh-privatekey=$HOME/.ssh/triton
    ```

1. Annotate Secret

    ```
    oc annotate secret/github-triton 'build.openshift.io/source-secret-match-uri-1=git@github.com/advlab/triton.git'
    ```

1. Create Image Streams

    ```
    oc process -f build-quickstart-imagestreams.yml | oc apply -f -
    ```

1. Build Images

    ```
    oc process -f build-quickstart-images.yml | oc apply -f -
    oc start-build build-tomcat-image && oc start-build build-jenkins-image
    ```

1. Deploy Template

    ```
    oc create -f deploy-quickstart.yml
    ```

1. Test Deployment

    Example:
    ```
    oc new-app -f deploy-quickstart.yml \
    -p CUSTOMER_ID=creditsuisse \
    -p GITHUB_ID=devopsmaniac \
    -p TOMCAT_USER=admin \
    -p TOMCAT_PASSWORD=changeit \
    -p JENKINS_USER=admin \
    -p JENKINS_PASSWORD=changeit
    ```