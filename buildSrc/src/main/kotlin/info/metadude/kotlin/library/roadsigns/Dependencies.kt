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
        const val constraintLayout = "1.1.3"
        const val espresso = "3.0.2"
        const val rules = "1.0.2"
        const val supportLibrary = "28.0.0"
    }

    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"

    object Support {

        const val annotations = "com.android.support:support-annotations:${Versions.supportLibrary}"
        const val appcompatV7 = "com.android.support:appcompat-v7:${Versions.supportLibrary}"
        const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"
        const val vectorDrawable = "com.android.support:support-vector-drawable:${Versions.supportLibrary}"

        object Test {

            const val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
            const val rules = "com.android.support.test:rules:${Versions.rules}"

        }

    }

}
