import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.plugin.statistics.ReportStatisticsToElasticSearch.url
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("kapt") version "1.6.10"
    id("org.jetbrains.compose") version "1.0.1"
}

group = "app.trian"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven {url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(compose.desktop.windows_x64)
    implementation(compose.desktop.linux_x64)
    implementation(compose.desktop.macos_x64)

    implementation("br.com.devsrsouza.compose.icons.jetbrains:octicons:1.0.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation ("com.google.code.gson:gson:2.8.7")
    implementation ("com.squareup.okhttp3:okhttp-tls:4.9.2")
    implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    //  Dagger 2
    api("com.google.dagger:dagger:2.39.1")
    kapt("com.google.dagger:dagger-compiler:2.39.1")
    kapt("com.google.dagger:dagger-compiler:2.39.1")
    kaptTest("com.google.dagger:dagger-compiler:2.39.1")
    implementation ("org.json:json:20200518")


}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}


compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "CryptoWallet"
            packageVersion = "1.0.0"
        }
    }
}
kapt {
    correctErrorTypes = true
}