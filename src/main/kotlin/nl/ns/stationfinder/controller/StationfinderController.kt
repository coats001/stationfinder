package nl.ns.stationfinder.controller

import nl.ns.stationfinder.model.Station
import nl.ns.stationfinder.service.NSAPIService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class StationfinderController(
        private val nsApiService: NSAPIService
) {


    @GetMapping(value = ["/api/v1/stations/{code}"])
    fun stationByCode(@PathVariable code: String): Mono<List<Station>> {
        return nsApiService.fetchStations().map { stations -> stations.filter { station -> station.code.equals(code) } }
    }

    @GetMapping(value = ["/api/v1/stations"])
    fun searchStations(@RequestParam(value= "search", required = false) search: String?): Mono<List<Station>> {
        return if (search == null) {
            nsApiService.fetchStations()
        } else {
            nsApiService.fetchStations().map { stations -> stations.filter { station -> station.code.contains(search) } }
        }
    }

    @GetMapping(value = ["/api/v1/stations?lat={lattitude}&lon={longitude}&radius={radius}"])
    fun stationsByGeoLocation(@PathVariable lattitude: String,
                              @PathVariable longitude: String,
                              @PathVariable radius: String): Mono<List<Station>> {
        return nsApiService.fetchStations()
    }


}