package nl.ns.stationfinder.model

data class Station(
    val EVACode: String,
    val UICCode: String,
    val code: String,
    val heeftFaciliteiten: Boolean,
    val heeftReisassistentie: Boolean,
    val heeftVertrektijden: Boolean,
    val ingangsDatum: String,
    val land: String,
    val lat: Double,
    val lng: Double,
    val naderenRadius: Int,
    val namen: Namen,
    val radius: Int,
    val sporen: List<Any>,
    val stationType: String,
    val synoniemen: List<String>
)

data class Namen(
    val kort: String,
    val lang: String,
    val middel: String
)

data class Payload(
    val payload: List<Station>
)
