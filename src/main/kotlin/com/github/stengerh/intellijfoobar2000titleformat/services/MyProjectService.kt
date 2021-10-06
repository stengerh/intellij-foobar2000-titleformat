package com.github.stengerh.intellijfoobar2000titleformat.services

import com.intellij.openapi.project.Project
import com.github.stengerh.intellijfoobar2000titleformat.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
