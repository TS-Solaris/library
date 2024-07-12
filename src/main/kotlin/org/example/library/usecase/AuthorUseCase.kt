package org.example.library.usecase

import org.example.library.domain.author.Author
import org.example.library.domain.author.AuthorService
import org.springframework.stereotype.Component

@Component
class AuthorUseCase(
    private val authorService: AuthorService,
) {
    fun create(author: Author) {
        authorService.create(author)
    }

    fun update(author: Author) {
        authorService.update(author)
    }

    fun searchByName(authorName: String?): List<Author> {
        return authorService.searchByName(authorName)
    }
}
