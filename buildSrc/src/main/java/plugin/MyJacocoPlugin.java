package plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.testing.Test;
import org.gradle.testing.jacoco.plugins.JacocoPlugin;
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension;

public class MyJacocoPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getPlugins().apply(JacocoPlugin.class);
        project.getTasks().withType(Test.class).configureEach(test -> {
            test.getExtensions().getByType(JacocoTaskExtension.class).setDestinationFile(
                    project.file("${project.buildDir}/jacoco/test.exec")
            );
        });
    }
}
