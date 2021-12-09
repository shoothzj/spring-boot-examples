plugins {
    java
}

group = "com.github.shoothzj"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
        annotationProcessor("org.projectlombok:lombok:1.18.22")
        compileOnly("org.projectlombok:lombok:1.18.22")
        implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.0")
        implementation("org.springframework.cloud:spring-cloud-starter-zookeeper-discovery:3.1.0")
        implementation("org.springframework.boot:spring-boot-starter-web:2.6.1")
        testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.1")
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}