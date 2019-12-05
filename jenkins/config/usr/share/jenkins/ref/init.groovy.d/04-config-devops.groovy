import jenkins.model.*
import java.util.logging.Logger

// Get Logger
Logger logger = Logger.getLogger(this.class)

// Get System Environment
def env = System.getenv()

// Get Jenkins Instance
Jenkins jenkins = Jenkins.getInstance()

// Get DevOps Plugin
def devops = jenkins.getDescriptor("io.jenkins.plugins.config.DevOpsConfiguration")

// Set DevOps Plugin Properties
logger.info("Configuring DevOps Plugin")
devops.snDevopsEnabled=true
devops.instanceUrl=env.NOW_URL
devops.apiVersion=env.NOW_API_VERSION
devops.user=env.NOW_USER
devops.pwd=env.NOW_PASSWORD
devops.toolId=env.NOW_TOOLID
devops.debug=false

// Test Config
logger.info("Testing ServiceNow Connection")
devops.doTestConnection(env.NOW_URL,env.NOW_API_VERSION,env.NOW_USER,env.NOW_PASSWORD,env.NOW_TOOLID)

// Save Config
logger.info("Saving Jenkins Configuration")
devops.save()