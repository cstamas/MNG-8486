package org.apache.maven.issues.mng8468;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "test")
public class TestMojo extends AbstractMojo {
    @Parameter(defaultValue = "${session}", readonly = true, required = true)
    private MavenSession session;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Java System Property:");
        getLog().info("jib.to.image = " + System.getProperty("jib.to.image"));
        getLog().info("Maven Session:");
        getLog().info("(user) jib.to.image = " + session.getUserProperties().getProperty("jib.to.image"));
        getLog().info("(system) jib.to.image = " + session.getSystemProperties().getProperty("jib.to.image"));
        getLog().info("Maven Resolver Session:");
        getLog().info("(user) jib.to.image = " + session.getRepositorySession().getUserProperties().get("jib.to.image"));
        getLog().info("(system) jib.to.image = " + session.getRepositorySession().getSystemProperties().get("jib.to.image"));
        getLog().info("(config) jib.to.image = " + session.getRepositorySession().getConfigProperties().get("jib.to.image"));
    }
}
