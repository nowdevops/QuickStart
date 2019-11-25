import jenkins.model.*
import com.cloudbees.hudson.plugins.folder.*;
import com.cloudbees.hudson.plugins.folder.properties.*;
import com.cloudbees.hudson.plugins.folder.properties.FolderCredentialsProvider.FolderCredentialsProperty;
import com.cloudbees.plugins.credentials.impl.*;
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.domains.*;

def env = System.getenv()

jenkins = Jenkins.instance

String id = "tomcat"
String description = "Tomcat Credentials"
Credentials credentials = new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL, id, description, env.TOMCAT_USER, env.TOMCAT_PASSWORD)

for (folder in jenkins.getAllItems(Folder.class)) {
  if(folder.name.equals('FolderName')){
	AbstractFolder<?> folderAbs = AbstractFolder.class.cast(folder)
    FolderCredentialsProperty property = folderAbs.getProperties().get(FolderCredentialsProperty.class)
    property.getStore().addCredentials(Domain.global(), credentials)
    println property.getCredentials().toString()
  }
}