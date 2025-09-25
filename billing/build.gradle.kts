plugins {
    `java-library`
}

java {
    withJavadocJar()
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":costumer"))
}
