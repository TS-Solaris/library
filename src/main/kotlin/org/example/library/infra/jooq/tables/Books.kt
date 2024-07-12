/*
 * This file is generated by jOOQ.
 */
package org.example.library.infra.jooq.tables

import org.example.library.infra.jooq.Public
import org.example.library.infra.jooq.keys.BOOKS_PKEY
import org.example.library.infra.jooq.keys.BOOKS__BOOKS_AUTHOR_ID_FKEY
import org.example.library.infra.jooq.tables.Authors.AuthorsPath
import org.example.library.infra.jooq.tables.records.BooksRecord
import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.Path
import org.jooq.PlainSQL
import org.jooq.QueryPart
import org.jooq.Record
import org.jooq.SQL
import org.jooq.Schema
import org.jooq.Select
import org.jooq.Stringly
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl
import java.time.OffsetDateTime
import java.util.UUID
import kotlin.collections.Collection
import kotlin.collections.List

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Books(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, BooksRecord>?,
    parentPath: InverseForeignKey<out Record, BooksRecord>?,
    aliased: Table<BooksRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?,
) : TableImpl<BooksRecord>(
        alias,
        Public.PUBLIC,
        path,
        childPath,
        parentPath,
        aliased,
        parameters,
        DSL.comment(""),
        TableOptions.table(),
        where,
    ) {
    companion object {
        /**
         * The reference instance of <code>public.books</code>
         */
        val BOOKS: Books = Books()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<BooksRecord> = BooksRecord::class.java

    /**
     * The column <code>public.books.id</code>.
     */
    val ID: TableField<BooksRecord, UUID?> = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "")

    /**
     * The column <code>public.books.title</code>.
     */
    val TITLE: TableField<BooksRecord, String?> = createField(DSL.name("title"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.books.author_id</code>.
     */
    val AUTHOR_ID: TableField<BooksRecord, UUID?> = createField(DSL.name("author_id"), SQLDataType.UUID.nullable(false), this, "")

    /**
     * The column <code>public.books.created_at</code>.
     */
    val CREATED_AT: TableField<BooksRecord, OffsetDateTime?> =
        createField(
            DSL.name("created_at"),
            SQLDataType
                .TIMESTAMPWITHTIMEZONE(6)
                .nullable(false)
                .defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.TIMESTAMPWITHTIMEZONE)),
            this, "",
        )

    /**
     * The column <code>public.books.updated_at</code>.
     */
    val UPDATED_AT: TableField<BooksRecord, OffsetDateTime?> =
        createField(
            DSL.name("updated_at"),
            SQLDataType
                .TIMESTAMPWITHTIMEZONE(6)
                .nullable(false)
                .defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.TIMESTAMPWITHTIMEZONE)),
            this, "",
        )

    private constructor(alias: Name, aliased: Table<BooksRecord>?) : this(alias, null, null, null, aliased, null, null)
    private constructor(
        alias: Name,
        aliased: Table<BooksRecord>?,
        parameters: Array<Field<*>?>?,
    ) : this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<BooksRecord>?, where: Condition?) : this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.books</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.books</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.books</code> table reference
     */
    constructor() : this(DSL.name("books"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, BooksRecord>?, parentPath: InverseForeignKey<out Record, BooksRecord>?) : this(
        Internal
            .createPathAlias(path, childPath, parentPath),
        path, childPath, parentPath, BOOKS, null, null,
    )

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class BooksPath :
        Books,
        Path<BooksRecord> {
        constructor(
            path: Table<out Record>,
            childPath: ForeignKey<out Record, BooksRecord>?,
            parentPath: InverseForeignKey<out Record, BooksRecord>?,
        ) : super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<BooksRecord>) : super(alias, aliased)
        override fun `as`(alias: String): BooksPath = BooksPath(DSL.name(alias), this)
        override fun `as`(alias: Name): BooksPath = BooksPath(alias, this)
        override fun `as`(alias: Table<*>): BooksPath = BooksPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getPrimaryKey(): UniqueKey<BooksRecord> = BOOKS_PKEY
    override fun getReferences(): List<ForeignKey<BooksRecord, *>> = listOf(BOOKS__BOOKS_AUTHOR_ID_FKEY)

    private lateinit var _authors: AuthorsPath

    /**
     * Get the implicit join path to the <code>public.authors</code> table.
     */
    fun authors(): AuthorsPath {
        if (!this::_authors.isInitialized) {
            _authors = AuthorsPath(this, BOOKS__BOOKS_AUTHOR_ID_FKEY, null)
        }

        return _authors
    }

    val authors: AuthorsPath
        get(): AuthorsPath = authors()
    override fun `as`(alias: String): Books = Books(DSL.name(alias), this)
    override fun `as`(alias: Name): Books = Books(alias, this)
    override fun `as`(alias: Table<*>): Books = Books(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Books = Books(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Books = Books(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Books = Books(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): Books = Books(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): Books = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): Books = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): Books = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): Books = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(
        @Stringly.SQL condition: String,
    ): Books = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(
        @Stringly.SQL condition: String,
        vararg binds: Any?,
    ): Books = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(
        @Stringly.SQL condition: String,
        vararg parts: QueryPart,
    ): Books = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): Books = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): Books = where(DSL.notExists(select))
}
