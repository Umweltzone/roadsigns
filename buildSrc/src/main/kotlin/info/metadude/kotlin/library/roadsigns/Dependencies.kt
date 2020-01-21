@file:Suppress("unused")

package info.metadude.kotlin.library.roadsigns

object Android {
    const val compileSdkVersion = 28
    const val minSdkVersion = 14
    const val targetSdkVersion = 28
}

private const val kotlinVersion = "1.3.61"

object Plugins {

    private object Versions {
        const val android = "3.5.3"
        const val androidMavenPublish = "3.6.3"
        const val bintray = "1.8.4"
        const val versions = "0.27.0"
    }

    const val android = "com.android.tools.build:gradle:${Versions.android}"
    const val androidMavenPublish = "digital.wup:android-maven-publish:${Versions.androidMavenPublish}"
    const val bintray = "com.jfrog.bintray.gradle:gradle-bintray-plugin:${Versions.bintray}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val versions = "com.github.ben-manes:gradle-versions-plugin:${Versions.versions}"
}

object Libs {

    private object Versions {
        const val annotation = "1.1.0"
        const val appCompat = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val espresso = "3.2.0"
        const val rules = "1.2.0"
        const val testExtJunit = "1.1.1"
        const val vectorDrawable = "1.1.0"
    }

    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"

    object Support {

        const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val vectorDrawable = "androidx.vectordrawable:vectordrawable:${Versions.vectorDrawable}"

        object Test {

            const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
            const val rules = "androidx.test:rules:${Versions.rules}"
            const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtJunit}"
        }

    }

}
