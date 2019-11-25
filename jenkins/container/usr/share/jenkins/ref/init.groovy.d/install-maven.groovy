import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;

// Set Maven Version
mavenVersion = "3.6.0";

// Create Maven Installer
newMavenInstall = new hudson.tasks.Maven.MavenInstallation('Maven', null,[new hudson.tools.InstallSourceProperty([new hudson.tasks.Maven.MavenInstaller(mavenVersion)])]);

// Create Maven Plugin
mavenPlugin = Jenkins.instance.getExtensionList(hudson.tasks.Maven.DescriptorImpl.class)[0];

// Install Maven Plugin
mavenPlugin.installations += newMavenInstall;

// Save Maven Plugin
mavenPlugin.save();