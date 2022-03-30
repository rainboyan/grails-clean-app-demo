package org.grails.demo

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import groovy.transform.CompileStatic
import org.springframework.context.annotation.ComponentScan
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup

@CompileStatic
@ComponentScan
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
         def now = System.currentTimeMillis()

        BufferingApplicationStartup startup = new BufferingApplicationStartup(2048)
        startup.addFilter(startupStep -> startupStep.getName().matches("spring.beans.instantiate"))

        GrailsApp grailsApp = new GrailsApp(Application)
        grailsApp.setApplicationStartup(startup)
        grailsApp.enableBeanCreationProfiler = true

        grailsApp.run(args)

        println "${System.currentTimeMillis()-now}ms"
    }
}