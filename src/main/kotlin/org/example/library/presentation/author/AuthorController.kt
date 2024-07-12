package org.example.library.presentation.author

import org.example.library.domain.author.Author
import org.example.library.usecase.AuthorUseCase
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("authors")
class AuthorController(
    private val authorUseCase: AuthorUseCase,
) {
    @PostMapping("")
    fun createAuthor(
        @RequestBody authorRequest: AuthorRequest,
    ) {
        val author = Author(authorRequest.name)
        authorUseCase.create(author)
    }

    @GetMapping("")
    fun getAuthors(
        @RequestParam(name = "name", required = false) authorName: String?,
    ): List<AuthorResponse> {
        return authorUseCase.searchByName(authorName).map { AuthorResponse(it.id, it.name) }
    }

    @PutMapping("{id}")
    fun updateAuthor(
        @RequestBody authorRequest: AuthorRequest,
        @PathVariable(name = "id") authorId: UUID,
    ) {
        val author = Author(authorId, authorRequest.name)
        authorUseCase.update(author)
    }
}
