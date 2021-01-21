package nl.ns.stationfinder.service

import nl.ns.stationfinder.model.Payload
import nl.ns.stationfinder.model.Station
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class NSAPIService {

    fun fetchStations(): Mono<List<Station>> {
        return fetch("/api/v2/stations")
                .bodyToMono(Payload::class.java)
                .map { payload ->
                    payload.payload
                }
    }


    fun fetch(path: String): WebClient.ResponseSpec {
        val client = WebClient.create("https://reisinfo.ns-mlab.nl/")
        return client.get().uri(path).retrieve()
    }
}