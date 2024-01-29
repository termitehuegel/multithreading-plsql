package dummyGenderator

import kotlin.random.Random

// From https://de.wikipedia.org/wiki/Liste_der_h%C3%A4ufigsten_Familiennamen_in_Deutschland
val names: List<String> = listOf(
    "Müller", "Schmidt", "Schneider", "Fischer", "Weber", "Meyer", "Wagner", "Becker", "Schulz", "Hoffmann"
)

// From
val firstNames: List<String> = listOf(
    ""
)

// From https://de.wikipedia.org/wiki/Liste_der_Staaten_der_Erde
val countries: List<String> = listOf(
    "Abchasien",
    "Afghanistan",
    "Ägypten",
    "Albanien",
    "Algerien",
    "Andorra",
    "Angola",
    "Antigua und Barbuda",
    "Äquatorialguinea",
    "Argentinien",
    "Armenien",
    "Aserbaidschan",
    "Äthiopien",
    "Australien"
)

// From https://de.wikipedia.org/wiki/Liste_der_gr%C3%B6%C3%9Ften_St%C3%A4dte_Europas
val cities: List<String> = listOf(
    "Istanbul",
    "Moskau",
    "London",
    "Sankt Petersburg",
    "Berlin",
    "Madrid",
    "Kiew",
    "Rom",
    "Paris",
    "Wien",
    "Minsk",
    "Hamburg",
    "Warschau",
    "Bukarest",
    "Budapest",
    "Barcelona",
    "München",
    "Charkiw",
    "Mailand",
    "Prag"
)

// From https://de.wikipedia.org/wiki/Liste_von_Ausbildungsberufen
val occupations: List<String> = listOf(
    "Biologiemodellmacher",
    "Bootsbauer",
    "Bürsten- und Pinselmacher",
    "Drechsler",
    "Fachkraft für Holz- und Bautenschutzarbeiten",
    "Flechtwerkgestalter",
    "Holzbearbeitungsmechaniker",
    "Holzbildhauer",
    "Holzmechaniker",
    "Holzspielzeugmacher",
    "Holz- und Bautenschützer",
    "Böttcher",
    "Leichtflugzeugbauer",
    "Rollladen- und Sonnenschutzmechatroniker",
    "Schirmmacher",
    "Spielzeughersteller",
    "Technischer Modellbauer",
    "Tischler",
    "Schreiner",
    "Bogenmacher",
    "Geigenbauer",
    "Handzuginstrumentenmacher",
    "Holzblasinstrumentenmacher",
    "Klavier- und Cembalobauer",
    "Metallblasinstrumentenmacher",
    "Orgelbauer",
    "Zupfinstrumentenmacher"
)


fun main() {
    val tableName: String = "PERSON_DATA_A"

    val insertStatement: StringBuilder = StringBuilder();
    insertStatement.append("INSERT INTO `$tableName` (`name`,`first_name`, `postcode`, `city`, `country`, `occupation`) VALUES \n")
    for (i in 0..100) {
        val person: Person =
            Person(
                names.random(),
                firstNames.random(),
                Random.nextInt(10000, 99999).toString(),
                cities.random(),
                countries.random(),
                occupations.random()
            )
        insertStatement.append(person)
        if (i < 100) {
            insertStatement.append(",\n")
        }
    }
    insertStatement.append(";")
    println(insertStatement.toString())
}

data class Person(
    val name: String,
    val firstName: String,
    val postcode: String,
    val city: String,
    val country: String,
    val occupation: String
) {
    override fun toString(): String {
        return "('$name', '$firstName', '$postcode', '$city', '$country', '$occupation')"
    }
}

