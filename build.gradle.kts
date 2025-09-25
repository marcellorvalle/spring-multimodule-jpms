plugins {
    id("org.springframework.boot") version "3.5.6"
    id("io.spring.dependency-management") version "1.1.7"
    java
}

group = "mrv"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-web")

        // Adicione estas dependências explicitamente
        implementation("org.slf4j:slf4j-api")
        implementation("ch.qos.logback:logback-classic")

        compileOnly("org.projectlombok:lombok")
        developmentOnly("org.springframework.boot:spring-boot-devtools")

        runtimeOnly("com.h2database:h2")
        annotationProcessor("org.projectlombok:lombok")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
