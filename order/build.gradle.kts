plugins {
    `java-library`
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":costumer"))
    implementation("org.springframework:spring-context:6.0.18")
}
