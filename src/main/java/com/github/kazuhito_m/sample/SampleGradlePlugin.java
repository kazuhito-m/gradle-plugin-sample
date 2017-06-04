package com.github.kazuhito_m.sample;

import groovy.lang.Closure;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class SampleGradlePlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {

        project.getExtensions().create("helloTestTest", SampleGradlePluginConfiguration.class);

        System.out.println("apply時点");

        project.task("hello").doLast(new Closure<Object>(this) {
            @Override
            public Object call() {
                System.out.println("テスト");

//                Object extension = project.getExtensions().getByName("helloTestTest");
//                System.out.println("extensionのクラス名 : " + extension.getClass().getName());
//                SampleGradlePluginConfiguration configuration = (SampleGradlePluginConfiguration) extension;

                SampleGradlePluginConfiguration configuration = project.getExtensions().getByType(SampleGradlePluginConfiguration.class);

                System.out.println("受け取ったパラメータ : " + configuration.getPropertyValue());

                return "何を返したらなっとくなんだ。";
            }
        });

        System.out.println("apply終了時点");

    }
}
