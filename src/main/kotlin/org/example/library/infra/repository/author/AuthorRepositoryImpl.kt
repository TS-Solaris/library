package org.example.library.infra.repository.author

import org.example.library.domain.author.Author
import org.example.library.domain.author.AuthorRepository
import org.example.library.infra.jooq.tables.references.AUTHORS
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class AuthorRepositoryImpl(
    private val create: DSLContext,
) : AuthorRepository {
    override fun create(author: Author) {
        create
            .insertInto(AUTHORS)
            .set(AUTHORS.ID, author.id)
            .set(AUTHORS.NAME, author.name)
            .execute()
    }

    override fun update(author: Author) {
        create
            .update(AUTHORS)
            .set(AUTHORS.NAME, author.name)
            .set(AUTHORS.UPDATED_AT, OffsetDateTime.now())
            .where(AUTHORS.ID.eq(author.id))
            .execute()
    }

    override fun searchByName(authorName: String?): List<Author> =
        create
            .selectFrom(AUTHORS)
            .apply { if (authorName != null) where(AUTHORS.NAME.likeIgnoreCase("%$authorName%")) }
            .orderBy(AUTHORS.CREATED_AT.desc())
            .fetch { Author(it.id, it.name) }
}
