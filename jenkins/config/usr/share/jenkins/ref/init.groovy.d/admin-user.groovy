import jenkins.model.*
import hudson.security.*

// Get System Environment
def env = System.getenv()

// Get Jenkins Instance
def jenkins = Jenkins.getInstance()

// Set Security Realms
if(!(jenkins.getSecurityRealm() instanceof HudsonPrivateSecurityRealm))
    jenkins.setSecurityRealm(new HudsonPrivateSecurityRealm(false))

if(!(jenkins.getAuthorizationStrategy() instanceof GlobalMatrixAuthorizationStrategy))
    jenkins.setAuthorizationStrategy(new GlobalMatrixAuthorizationStrategy())

// Create User
def user = jenkins.getSecurityRealm().createAccount(env.JENKINS_USER, env.JENKINS_PASSWORD)
user.save()

// Set User as Jenkins Administrator
jenkins.getAuthorizationStrategy().add(Jenkins.ADMINISTER, env.JENKINS_USER)
jenkins.save()