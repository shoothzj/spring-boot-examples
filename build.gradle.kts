plugins {
    java
}

group = "com.github.shoothzj"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
