plugins {
    id("org.springframework.boot") version "4.1.0-RC1"
    id("io.spring.dependency-management") version "1.1.7"
    java
}

group = "example"
version = "0.0.1-SNAPSHOT"

repositories {
    maven {
        url = uri("https://repo.spring.io/snapshot")
    }
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.modulith:spring-modulith-bom:2.1.0-SNAPSHOT")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.modulith:spring-modulith-starter-core")
    implementation("org.springframework.modulith:spring-modulith-starter-insight")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
