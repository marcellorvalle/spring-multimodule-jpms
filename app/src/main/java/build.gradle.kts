plugins {
    id("org.springframework.boot") version "3.3.2"
    id("io.spring.dependency-management") version "1.1.2"
    java
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":costumer"))
    implementation(project(":order"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.named("test") {
    useJUnitPlatform()
}
