package com.fatec.tcc.animais.services.file

import com.fatec.tcc.animais.Runner
import java.io.File

interface FileService : Runner {
    fun <T> saveFile(input: T, name: String, impl: (T, File) -> Unit)
    fun readFile(name: String): ByteArray
}