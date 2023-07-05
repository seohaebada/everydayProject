package com.studyserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StudyServerApplication

fun main(args: Array<String>) {
    runApplication<StudyServerApplication>(*args)
}
