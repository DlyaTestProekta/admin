val springBootStarterVer: String by project // 3.3.1-SNAPSHOT
val springAdminVer: String by project // 3.2.3
val junitVer: String by project // 1.11.0-M2

plugins {
	java
	id("org.springframework.boot") version "3.3.1-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "ru.pachan"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/snapshot") }
}

extra["springBootAdminVersion"] = "3.2.3"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-security:$springBootStarterVer")
	implementation("org.springframework.boot:spring-boot-starter-web:$springBootStarterVer")
	implementation("de.codecentric:spring-boot-admin-starter-server:$springAdminVer")
	testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootStarterVer")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher:$junitVer")
}

dependencyManagement {
	imports {
		mavenBom("de.codecentric:spring-boot-admin-dependencies:${property("springBootAdminVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
