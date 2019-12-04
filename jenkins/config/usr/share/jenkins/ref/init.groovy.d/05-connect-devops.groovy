import jenkins.model.*
import java.util.logging.Logger

// Get Logger
Logger logger = Logger.getLogger("")

// Get System Environment
def env = System.getenv()

// Get Jenkins Instance
def jenkins = Jenkins.getInstance()

// Get DevOps Plugin
def devops = jenkins.getDescriptor("io.jenkins.plugins.config.DevOpsConfiguration")

// Test Config
logger.info("Testing ServiceNow Connection")
devops.doTestConnection(env.NOW_URL,env.NOW_API_VERSION,env.NOW_USER,env.NOW_PASSWORD,env.NOW_TOOLID)

// Wait
sleep(time:5,unit:"SECONDS")

// Save Config
jenkins.save()