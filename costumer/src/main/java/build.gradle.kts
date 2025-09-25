plugins {
    `java-library`
}

dependencies {
    implementation(project(":shared"))
    implementation("org.springframework:spring-context:6.0.18")
    implementation("org.springframework:spring-web:6.0.18")
    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}
