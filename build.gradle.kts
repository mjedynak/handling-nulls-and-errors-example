group = "pl.mjedynak"
version = "1.0-SNAPSHOT"

plugins {
    groovy
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testCompile("org.spockframework", "spock-core", "1.1-groovy-2.4")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_10
}