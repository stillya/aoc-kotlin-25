plugins {
	kotlin("jvm") version "2.2.21"
}

dependencies {
	implementation("io.github.dmitrynekrasov:kodvent:0.1.8")
}

sourceSets {
	main {
		kotlin.srcDir("src")
	}
}

tasks {
	wrapper {
		gradleVersion = "9.2.1"
	}
}
