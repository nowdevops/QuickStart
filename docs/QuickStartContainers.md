# Deploy QuickStart Containers

1. Login to OKD

1. Press `Add to Project > Browse Catalog`

1. Fiter by `ServiceNow` Publisher

1. Select the `Deploy Quickstart` Template

1. Press `Next`

1. Configure Template as follows:

    * Customer ID (e.g. `acme`)
    * GitHub ID (e.g. `dsmith`)
    * Tomcat User (e.g. `admin`)
    * Tomcat Password (e.g. `changeit`)
    * Jenkins User (e.g. `admin`)
    * Tomcat Password (e.g. `changeit`)
    * Tomcat Memory Limit (e.g. `1Gi`)
    * Jenkins Memory Limit (e.g. `1Gi`)
    * Jenkins Volume Capacity (e.g. `5Gi`)

1. Press `Create`

1. Navigate to `Overview`

    The Application you created will be listed grouped by Pod. Visit each Pod to note the avaiable Routes to each Pod. The Routes are named according to the following naming convention where `NAMESPACE=triton` for this installation:

    * http://CUSTOMER_ID-jenkins-NAMESPACE-openshift.sytes.net
    * http://CUSTOMER_ID-tomcat-NAMESPACE-openshift.sytes.net

    The Jenkins Pod is configured to deploy (2) two web applications and the URLs are as follows:

    * http://CUSTOMER_ID-tomcat-NAMESPACE-openshift.sytes.net/globex-web-prod
    * http://CUSTOMER_ID-tomcat-NAMESPACE-openshift.sytes.net/globex-web-uat