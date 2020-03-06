import jenkins.model.*
import hudson.security.*
import java.util.logging.Logger
import java.io.File

// Get System Environment
def env = System.getenv()

// Get Logger
Logger logger = Logger.getLogger("CreateAdminUser")

// Set Lock file
def lockFile = new File(env.JENKINS_HOME+'/configured.lock')

if (lockFile.exists()) {

    print("Jenkins Admin User already configured")

} else {

    print("Configuring Jenkins Admin User")

    // Get Jenkins Instance
    Jenkins jenkins = Jenkins.getInstance()

    // Set Security Realms
    if(!(jenkins.getSecurityRealm() instanceof HudsonPrivateSecurityRealm))
        jenkins.setSecurityRealm(new HudsonPrivateSecurityRealm(false))

    if(!(jenkins.getAuthorizationStrategy() instanceof GlobalMatrixAuthorizationStrategy))
        jenkins.setAuthorizationStrategy(new GlobalMatrixAuthorizationStrategy())

    // Create User
    print("Creating Default Admin User")
    def user = jenkins.getSecurityRealm().createAccount(env.JENKINS_USER, env.JENKINS_PASSWORD)
    user.save()

    // Set User as Jenkins Administrator
    jenkins.getAuthorizationStrategy().add(Jenkins.ADMINISTER, env.JENKINS_USER)
    jenkins.save()
}

