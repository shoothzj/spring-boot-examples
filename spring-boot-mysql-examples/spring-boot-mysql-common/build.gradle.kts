plugins {
    java
}

group = "com.github.shoothzj"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    compileOnly("org.projectlombok:lombok:1.18.22")
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.6")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.6")
    implementation("com.mysql:mysql-connector-j:8.0.32")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.6")
    testImplementation("com.h2database:h2:1.4.200")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}