package ch.apptiva.dynamiclinks.analytics

import com.google.auth.oauth2.GoogleCredentials
import io.github.rybalkinsd.kohttp.dsl.httpGet
import io.github.rybalkinsd.kohttp.ext.asString
import io.github.rybalkinsd.kohttp.ext.url
import java.io.FileInputStream
import java.net.URLEncoder
import java.util.*


fun main(args: Array<String>) {
    val dynamicLink = "https://suva.page.link/testApptiva"
    val config = readConfig()
    val serviceAccount = FileInputStream("./service-account.json")
    val googleCredentials = GoogleCredentials.fromStream(serviceAccount)
    val scoped = googleCredentials.createScoped(
        Arrays.asList<String>("https://www.googleapis.com/auth/firebase")
    )

    val token = scoped.refreshAccessToken()

    config.links.forEach { link ->
        val dynamicShortLinkEncoded = URLEncoder.encode(dynamicLink, "UTF-8")
        val response = httpGet {
            url("https://firebasedynamiclinks.googleapis.com/v1/${dynamicShortLinkEncoded}/linkStats?durationDays=${config.days}")
            header {
                "Authorization" to "Bearer ${token.tokenValue}"
            }
        }
        println("$link:")
        println(response.asString())
    }
}