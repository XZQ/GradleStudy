package com.xzq

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.security.DigestInputStream
import java.security.MessageDigest
import javax.xml.bind.annotation.adapters.HexBinaryAdapter


class GitHookPlugin : Plugin<Project> {

    override fun apply(project: Project) {


        println("--------------------------------------GitHookPlugin------------------------>>>>>>>")

//        val copyGitHookScriptTask = project.task(name = "copyGitHookScript", type = Copy::class) {
//            inputs.dir("${project.rootDir}/scripts${File.separator}git_commit_msg")
//            outputs.dir("${project.rootDir}/.git${File.separator}hooks")
//
//            from("${project.rootDir}/scripts${File.separator}git_commit_msg${File.separator}commit-msg")
//            into("${project.rootDir}/.git${File.separator}hooks")
//        }
//        project.gradle.afterProject {
//            if (name == "app") {
//                tasks.matching { it.name == "preDebugBuild" }.all {
//                    val md5FileSrc = md5File(
//                        file(
//                            StringBuilder(project.rootDir.absolutePath).append(File.separator)
//                                .append("scripts")
//                                .append(File.separator).append("git_commit_msg")
//                                .append(File.separator).append("commit-msg")
//                        )
//                    )
//                    val md5FileDst = md5File(
//                        file(
//                            StringBuilder(project.rootDir.absolutePath).append(File.separator)
//                                .append(".git")
//                                .append(File.separator).append("hooks")
//                                .append(File.separator).append("commit-msg")
//                        )
//                    )
//                    println("> ----- md5FileSrc:${md5FileSrc}, md5FileDst:${md5FileDst}")
//                    if (md5FileDst == null || md5FileDst != md5FileSrc) {
//                        dependsOn(copyGitHookScriptTask)
//                    }
//                }
//            }
//        }
    }

    private fun md5File(file: File): String? {
        if (!file.exists()) {
            return null
        }
        val md: MessageDigest = MessageDigest.getInstance("MD5")
        Files.newInputStream(Paths.get(file.absolutePath))
            .use { inputStream -> DigestInputStream(inputStream, md) }
        return (HexBinaryAdapter()).marshal(md.digest())
    }
}