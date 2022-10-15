package com.fatec.tcc.animais.services.file

import org.springframework.boot.ApplicationArguments
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import java.io.File

@Component
class PublicFileService : FileService {
    private val root = System.getProperty("user.home")
    private val separator = File.separatorChar

    private val public = "${separator}public${separator}images"
    private val relative = "${separator}backend$public"
    private val location = "$root$relative"

    override fun run(args: ApplicationArguments) {
        File(location).mkdirs()
    }

    override fun <T> saveFile(input: T, name: String, impl: (T, File) -> Unit): String {
        impl(input, File("$location$separator$name"))
        return "$public$separator$name"
    }

    override fun readFile(name: String): ByteArray {
        val file = File("$location${separator}$name")
        if (!file.exists()) throw ResponseStatusException(HttpStatus.NOT_FOUND)
        return file.inputStream().use {
            it.readAllBytes()
        }
    }
}