package com.covi201

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(DefaultHeaders)
    install(CallLogging)

    install(ContentNegotiation) {
        gson {
        }
    }

    install(Routing) {
        get(path = "/api/krit/covid") {
            val covild = Covid(
                Confirmed = 4008,
                Recovered = 3811,
                Hospitalized = 137,
                Deaths = 60,
                NewConfirmed = 10,
                NewRecovered = 8,
                NewHospitalized = 2,
                NewDeaths = 0,
                UpdateDate = "01/12/2020 17:22",
                Source = "https://covid19.th-stat.com/",
                DevBy = "https://www.kidkarnmai.com/",
                SeverBy = "https://smilehost.asia/")
            call.respond(covild)
        }

        get(path = "/api/krit/popkrit"){
            val popkrit = KKrit(
                name = "krit",
                age =  21)
            call.respond(popkrit)
        }

    }

}

data class Covid(
    val Confirmed: Int? = null,
    val Recovered: Int? = null,
    val Hospitalized: Int? = null,
    val Deaths: Int? = null,
    val NewConfirmed: Int? = null,
    val NewRecovered: Int? = null,
    val NewHospitalized: Int? = null,
    val NewDeaths: Int? = null,
    val UpdateDate: String? = null,
    val Source: String? = null,
    val DevBy: String? = null,
    val SeverBy: String? = null,


    )

data class KKrit(
    val name: String? = null,
    val age: Int? = null,

)