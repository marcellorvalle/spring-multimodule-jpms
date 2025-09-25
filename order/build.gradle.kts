plugins {
    `java-library`
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":costumer"))
    implementation(project(":product"))
    //implementation("org.springframework:spring-context:6.0.18")
}
