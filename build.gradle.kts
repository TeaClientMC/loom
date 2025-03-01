import net.minecrell.gitpatcher.PatchExtension

defaultTasks("clean")

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://maven.minecraftforge.net/")
    }
    dependencies {
        classpath("net.minecraftforge:gitpatcher:0.10.+")
    }
}

plugins {
	base
	id("net.minecrell.gitpatcher") version "0.9.0"
}

patches {
	  submodule = "architectury-loom"
    target = file("teaclient-loom")
    patches = file("patches")
}

tasks.named("clean") {
    doFirst {
        delete("${rootDir}/patched-loom")
    }
}
