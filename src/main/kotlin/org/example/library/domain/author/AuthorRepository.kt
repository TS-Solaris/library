package org.example.library.domain.author

interface AuthorRepository {
    fun create(author: Author)
    fun update(author: Author)
    fun searchByName(authorName: String?): List<Author>
}
