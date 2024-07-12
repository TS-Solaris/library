package org.example.library.domain.author

import org.springframework.stereotype.Service

@Service
class AuthorService(
    private val authorRepository: AuthorRepository,
) {
    fun create(author: Author) {
        if (authorRepository.searchByName(author.name).isNotEmpty()) throw IllegalArgumentException("同名の著者が存在します")
        authorRepository.create(author)
    }

    fun update(author: Author) {
        if (authorRepository.searchByName(author.name).isNotEmpty()) throw IllegalArgumentException("同名の著者が存在します")
        authorRepository.update(author)
    }

    fun searchByName(authorName: String?): List<Author> {
        return authorRepository.searchByName(authorName)
    }
}
