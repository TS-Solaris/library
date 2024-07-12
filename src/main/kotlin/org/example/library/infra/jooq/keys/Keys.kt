/*
 * This file is generated by jOOQ.
 */
package org.example.library.infra.jooq.keys

import org.example.library.infra.jooq.tables.Authors
import org.example.library.infra.jooq.tables.Books
import org.example.library.infra.jooq.tables.records.AuthorsRecord
import org.example.library.infra.jooq.tables.records.BooksRecord
import org.jooq.ForeignKey
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal

// -------------------------------------------------------------------------
// UNIQUE and PRIMARY KEY definitions
// -------------------------------------------------------------------------

val AUTHORS_PKEY: UniqueKey<AuthorsRecord> =
    Internal
        .createUniqueKey(Authors.AUTHORS, DSL.name("authors_pkey"), arrayOf(Authors.AUTHORS.ID), true)
val BOOKS_PKEY: UniqueKey<BooksRecord> = Internal.createUniqueKey(Books.BOOKS, DSL.name("books_pkey"), arrayOf(Books.BOOKS.ID), true)

// -------------------------------------------------------------------------
// FOREIGN KEY definitions
// -------------------------------------------------------------------------

val BOOKS__BOOKS_AUTHOR_ID_FKEY: ForeignKey<BooksRecord, AuthorsRecord> =
    Internal
        .createForeignKey(Books.BOOKS, DSL.name("books_author_id_fkey"), arrayOf(Books.BOOKS.AUTHOR_ID), org.example.library.infra.jooq.keys.AUTHORS_PKEY, arrayOf(Authors.AUTHORS.ID), true)