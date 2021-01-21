package nl.ns.stationfinder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StationfinderApplication

fun main(args: Array<String>) {
    runApplication<StationfinderApplication>(*args)
}
