package com.xzq

import org.gradle.api.Plugin
import org.gradle.api.Project

class Second implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task('showCustomPlugin') {
            doLast {
                println('hello world plugin!')
            }
        }
    }
}