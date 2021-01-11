import io.github.muth0mi.bibilia.buildsrc.Libs

buildscript {
    val kotlin_version by extra("1.4.21")
    val compose_version by extra("1.0.0-alpha09")

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-alpha04")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.28-alpha")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean").configure {
    delete("build")
}