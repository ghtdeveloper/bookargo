plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common:1.9.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
                implementation("androidx.webkit:webkit:1.4.0")
                implementation("org.jetbrains.compose.ui:ui:1.3.0")
                implementation("org.jetbrains.compose.foundation:foundation:1.3.0")
                implementation("org.jetbrains.compose.material:material:1.3.0")
                implementation("org.jetbrains.compose.runtime:runtime:1.3.0")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-common:1.9.0")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common:1.9.0")
            }
        }


        val androidMain by getting {
            dependencies {
                implementation("androidx.appcompat:appcompat:1.6.0")
                implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0")
                implementation("androidx.constraintlayout:constraintlayout:2.1.4")
                implementation("androidx.compose.ui:ui:1.3.0")
                implementation("androidx.compose.material:material:1.3.0")
                implementation("androidx.compose.ui:ui-tooling:1.3.0")
                implementation("androidx.compose.runtime:runtime:1.3.0")
                implementation("androidx.compose.foundation:foundation:1.3.0")
            }
        }

        val iosMain by creating {
            dependencies {
                implementation("org.jetbrains.compose.ui:ui:1.3.0")
                implementation("org.jetbrains.compose.foundation:foundation:1.3.0")
                implementation("org.jetbrains.compose.runtime:runtime:1.3.0")
            }
        }

    }
}

android {
    namespace = "com.jedsolution.bookargo"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
   /* implementation("org.jetbrains.compose.runtime:runtime:1.3.0")
    implementation(libs.androidx.ui.android)
    implementation(project(":shared"))*/
}
