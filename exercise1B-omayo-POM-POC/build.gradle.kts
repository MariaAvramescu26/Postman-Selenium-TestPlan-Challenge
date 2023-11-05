plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
    implementation("org.seleniumhq.selenium:selenium-api:3.141.59")
    implementation("org.seleniumhq.selenium:selenium-support:3.141.59")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    testImplementation("junit:junit:4.13.1")

}


tasks.test {
    useJUnitPlatform()
}

