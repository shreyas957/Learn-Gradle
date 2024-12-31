package dev.shreyas

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class CustomTask : DefaultTask() {
    // take string input to task
    @get:Input
    abstract val input: Property<String>

    @TaskAction
    fun customTask() {
        println(input.get() + " from custom task")
    }
}