package com.fatec.tcc.animais

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.*

data class Data(
    val name: String,
    val age: Int
)

@CrossOrigin
@RestController
@RequestMapping("/file")
class UploadTest {
    @PostMapping(
        consumes = [
            MediaType.MULTIPART_FORM_DATA_VALUE
        ]
    )
    fun uploadFiles(
        @RequestPart("files") files: Array<MultipartFile>
    ) {
        val root = System.getProperty("user.home")
        val separator = File.separatorChar
        val path = "$root${separator}backend${separator}images"
        val file = File(path)
        if (!file.exists()) file.mkdirs()
        for (f in files) {
            val extension = f.originalFilename?.substringAfterLast('.', "") ?: ""
            if (extension.isBlank()) continue
            val image = "$path$separator${UUID.randomUUID()}.$extension"
            f.transferTo(File(image))
        }
    }
}