package org.grails.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping('/')
    String index() {
        return "Hello World!"
    }
}
