import jenkins.model.*

// Get System Environment
def env = System.getenv()

// Get Jenkins Instance
def jenkins = Jenkins.getInstance()

// Get DevOps Plugin
def devops = jenkins.getDescriptor("io.jenkins.plugins.config.DevOpsConfiguration")

// Test Config
devops.doTestConnection(env.NOW_URL,env.NOW_API_VERSION,env.NOW_USER,env.NOW_PASSWORD,env.NOW_TOOLID)