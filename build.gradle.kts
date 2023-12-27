plugins {
    java
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    id("org.hibernate.orm") version "6.4.1.Final"
    id("org.graalvm.buildtools.native") version "0.9.28"
    id("io.freefair.lombok") version "8.4"
    id("org.openapi.generator") version "7.2.0"
}

group = "com.thushalil"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    implementation("org.springdoc:springdoc-openapi-ui:1.7.0")
    implementation("org.openapitools:jackson-databind-nullable:0.2.6")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

hibernate {
    enhancement {
        enableAssociationManagement.set(true)
    }
}

openApiGenerate {
    generatorName.set("spring")
    inputSpec.set("$rootDir/src/main/resources/openapi/api.yaml")
    outputDir.set("$buildDir/generated")
    apiPackage.set("com.thushalil.sampleopenapi.api")
    modelPackage.set("com.thushalil.sampleopenapi.api.model")
    invokerPackage.set("com.thushalil.sampleopenapi.api.invoker")
    configOptions.set(
        mapOf(
            "useSpringBoot3" to "true",
            "dateLibrary" to "java8",
            "interfaceOnly" to "true",
            "useBeanValidation" to "true",
            "useTags" to "true",
            "additionalModelTypeAnnotations" to "@lombok.AllArgsConstructor\n@lombok.NoArgsConstructor\n@lombok.experimental.SuperBuilder"
        )
    )
}

tasks.compileJava {
    dependsOn(tasks.openApiGenerate)
}

sourceSets {
    main {
        java.srcDir("$buildDir/generated/src/main/java")
    }
}
