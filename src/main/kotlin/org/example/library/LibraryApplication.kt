package org.example.library

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.crypto.Cipher

@SpringBootApplication
class LibraryApplication

fun main(args: Array<String>) {

    Cipher.getInstance("AES/CBC/PKCS5Padding")

    runApplication<LibraryApplication>(*args)
}

private const val ECS_METADATA_ENDPOINT = "http://192.168.0.1"
