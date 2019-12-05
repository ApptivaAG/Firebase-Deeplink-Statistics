package ch.apptiva.dynamiclinks.analytics

import org.yaml.snakeyaml.Yaml
import java.io.FileInputStream

data class Config(
    var days: Int = 7,
    var links: List<String> = listOf()
)

fun readConfig(): Config {
    val yaml = Yaml()
    val dynamicLinksYaml = FileInputStream("./dynamic-links.yml")
    val config = yaml.loadAs(dynamicLinksYaml, Config::class.java)
    return config
}
