import jenkins.model.*

// Local Variables
String apiVersion = "v1"

// Get System Environment
def env = System.getenv()

// Get Jenkins Instance
def jenkins = Jenkins.getInstance()

// Get DevOps Plugin
def devops = jenkins.getDescriptor("io.jenkins.plugins.config.DevOpsConfiguration")

// Set DevOps Plugin Properties
devops.snDevopsEnabled=true
devops.instanceUrl=env.NOW_URL
devops.apiVersion=apiVersion
devops.user=env.NOW_USER
devops.pwd=env.NOW_PASSWORD
devops.toolId=env.NOW_TOOLID
devops.debug=false

// Save Plugin
devops.save()

// Save Config
jenkins.save()