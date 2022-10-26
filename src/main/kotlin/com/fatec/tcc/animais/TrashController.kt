package com.fatec.tcc.animais

import com.fatec.tcc.animais.services.file.PublicFileService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile
import java.util.*

class TrashController(
    private val fileService: PublicFileService,
) {
    @GetMapping(
        "/images/{name}",
        produces = [
            MediaType.IMAGE_PNG_VALUE,
            MediaType.IMAGE_JPEG_VALUE,
            MediaType.IMAGE_GIF_VALUE
        ]
    )
    fun getImage(@PathVariable name: String): ByteArray = fileService.readFile(name)

    @PostMapping(
        "/images",
        consumes = [
            MediaType.MULTIPART_FORM_DATA_VALUE
        ]
    )
    fun pushImage(
        @RequestPart("files") files: Array<MultipartFile>
    ) {
        for (f in files) {
            val extension = f.originalFilename?.substringAfterLast('.', "") ?: continue
            val name = "${UUID.randomUUID()}.$extension"
            fileService.saveFile(f, name, MultipartFile::transferTo)
        }
    }
}