plugins {
    java
}

group = "com.github.shoothzj"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
        annotationProcessor("org.projectlombok:lombok:1.18.22")
        compileOnly("org.projectlombok:lombok:1.18.22")
        implementation("com.huaweicloud:spring-cloud-starter-huawei-config:1.9.0-Hoxton")
        implementation("com.huaweicloud:spring-cloud-starter-huawei-router:1.9.0-Hoxton")
        implementation("org.springframework.boot:spring-boot-starter-web:2.5.12")
        testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.12")
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}