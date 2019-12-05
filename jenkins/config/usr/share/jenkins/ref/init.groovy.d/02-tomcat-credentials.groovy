import jenkins.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import org.jenkinsci.plugins.plaincredentials.*
import org.jenkinsci.plugins.plaincredentials.impl.*
import hudson.util.Secret
import java.util.logging.Logger

// Get Logger
Logger logger = Logger.getLogger(this.class)

// Get System Environment
def env = System.getenv()

// Get Jenkins Store
def getStore() {
    return Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()
}

// Set Global Domain
domain = Domain.global()

// Create Credential
logger.info("Creating Tomcat connection credentials")
String id = "tomcat"
String description = "Tomcat Credentials"
Credentials credentials = (Credentials) new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL, id, description, env.TOMCAT_USER, env.TOMCAT_PASSWORD)

// Save Credential
getStore().addCredentials(domain, credentials)