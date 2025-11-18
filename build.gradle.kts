plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // TestNG untuk main dan test
    implementation("org.testng:testng:7.9.0")

    // Log4j
    implementation("org.apache.logging.log4j:log4j-api:2.22.0")
    implementation("org.apache.logging.log4j:log4j-core:2.22.0")

    // Extent Reports
    implementation("com.aventstack:extentreports:5.1.0")
}

tasks.test {
    useTestNG()
}
