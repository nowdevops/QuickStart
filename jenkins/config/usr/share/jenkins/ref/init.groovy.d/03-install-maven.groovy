import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;
import java.util.logging.Logger

// Get Logger
Logger logger = Logger.getLogger("")

// Set Maven Version
mavenVersion = "3.6.0";

// Create Maven Installer
newMavenInstall = new hudson.tasks.Maven.MavenInstallation('Maven', null,[new hudson.tools.InstallSourceProperty([new hudson.tasks.Maven.MavenInstaller(mavenVersion)])]);

// Create Maven Plugin
mavenPlugin = Jenkins.instance.getExtensionList(hudson.tasks.Maven.DescriptorImpl.class)[0];

// Install Maven Plugin
logger.info("Installing Maven")
mavenPlugin.installations += newMavenInstall;

// Save Maven Plugin
mavenPlugin.save();