@file:Suppress("unused")

package info.metadude.kotlin.library.roadsigns

object Android {
    const val compileSdkVersion = 30
    const val minSdkVersion = 14
    const val targetSdkVersion = 30
}

object Plugins {

    private object Versions {
        const val android = "4.2.2"
        const val dokka = "1.5.31"
        const val kotlin = "1.5.31"
        const val versions = "0.39.0"
    }

    const val android = "com.android.tools.build:gradle:${Versions.android}"
    const val dokka = "org.jetbrains.dokka:dokka-gradle-plugin:${Versions.dokka}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val versions = "com.github.ben-manes:gradle-versions-plugin:${Versions.versions}"
}

object Libs {

    private object Versions {
        const val annotation = "1.3.0"
        const val appCompat = "1.3.1"
        const val constraintLayout = "2.1.1"
        const val espresso = "3.4.0"
        const val testExtJunit = "1.1.3"
        const val vectorDrawable = "1.1.0"
    }

    object Support {

        const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val vectorDrawable =
            "androidx.vectordrawable:vectordrawable:${Versions.vectorDrawable}"

        object Test {

            const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
            const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtJunit}"
        }

    }

}
