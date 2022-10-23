package com.fatec.tcc.animais.public

import com.fatec.tcc.animais.content.domain.usecase.GetContentProjectionInEvidenceUseCase
import com.fatec.tcc.animais.services.file.PublicFileService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RestController
@SecurityRequirement(name = "jwt")
@RequestMapping("/public")
class PublicController(
    private val fileService: PublicFileService,
    private val getContentProjectionInEvidenceUseCase: GetContentProjectionInEvidenceUseCase
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

    @GetMapping("/content/evidence")
    fun getContentProjectionInEvidence() = getContentProjectionInEvidenceUseCase()
}