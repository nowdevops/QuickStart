import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;

mavenVersion = "3.6.0";

mavenPlugin = Jenkins.instance.getExtensionList(hudson.tasks.Maven.DescriptorImpl.class)[0];

newMavenInstall = new hudson.tasks.Maven.MavenInstallation('Maven', null,[new hudson.tools.InstallSourceProperty([new hudson.tasks.Maven.MavenInstaller(mavenVersion)])]);

mavenPlugin.installations += newMavenInstall;

mavenPlugin.save();