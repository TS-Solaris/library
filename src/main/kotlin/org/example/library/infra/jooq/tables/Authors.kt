/*
 * This file is generated by jOOQ.
 */
package org.example.library.infra.jooq.tables

import org.example.library.infra.jooq.Public
import org.example.library.infra.jooq.keys.AUTHORS_PKEY
import org.example.library.infra.jooq.keys.BOOKS__BOOKS_AUTHOR_ID_FKEY
import org.example.library.infra.jooq.tables.Books.BooksPath
import org.example.library.infra.jooq.tables.records.AuthorsRecord
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

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Authors(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, AuthorsRecord>?,
    parentPath: InverseForeignKey<out Record, AuthorsRecord>?,
    aliased: Table<AuthorsRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?,
) : TableImpl<AuthorsRecord>(
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
         * The reference instance of <code>public.authors</code>
         */
        val AUTHORS: Authors = Authors()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<AuthorsRecord> = AuthorsRecord::class.java

    /**
     * The column <code>public.authors.id</code>.
     */
    val ID: TableField<AuthorsRecord, UUID?> = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "")

    /**
     * The column <code>public.authors.name</code>.
     */
    val NAME: TableField<AuthorsRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.authors.created_at</code>.
     */
    val CREATED_AT: TableField<AuthorsRecord, OffsetDateTime?> =
        createField(
            DSL.name("created_at"),
            SQLDataType
                .TIMESTAMPWITHTIMEZONE(6)
                .nullable(false)
                .defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.TIMESTAMPWITHTIMEZONE)),
            this, "",
        )

    /**
     * The column <code>public.authors.updated_at</code>.
     */
    val UPDATED_AT: TableField<AuthorsRecord, OffsetDateTime?> =
        createField(
            DSL.name("updated_at"),
            SQLDataType
                .TIMESTAMPWITHTIMEZONE(6)
                .nullable(false)
                .defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.TIMESTAMPWITHTIMEZONE)),
            this, "",
        )

    private constructor(alias: Name, aliased: Table<AuthorsRecord>?) : this(alias, null, null, null, aliased, null, null)
    private constructor(
        alias: Name,
        aliased: Table<AuthorsRecord>?,
        parameters: Array<Field<*>?>?,
    ) : this(alias, null, null, null, aliased, parameters, null)
    private constructor(
        alias: Name,
        aliased: Table<AuthorsRecord>?,
        where: Condition?,
    ) : this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.authors</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.authors</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.authors</code> table reference
     */
    constructor() : this(DSL.name("authors"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, AuthorsRecord>?, parentPath: InverseForeignKey<out Record, AuthorsRecord>?) : this(
        Internal
            .createPathAlias(path, childPath, parentPath),
        path, childPath, parentPath, AUTHORS, null, null,
    )

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class AuthorsPath :
        Authors,
        Path<AuthorsRecord> {
        constructor(
            path: Table<out Record>,
            childPath: ForeignKey<out Record, AuthorsRecord>?,
            parentPath: InverseForeignKey<out Record, AuthorsRecord>?,
        ) : super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<AuthorsRecord>) : super(alias, aliased)
        override fun `as`(alias: String): AuthorsPath = AuthorsPath(DSL.name(alias), this)
        override fun `as`(alias: Name): AuthorsPath = AuthorsPath(alias, this)
        override fun `as`(alias: Table<*>): AuthorsPath = AuthorsPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getPrimaryKey(): UniqueKey<AuthorsRecord> = AUTHORS_PKEY

    private lateinit var _books: BooksPath

    /**
     * Get the implicit to-many join path to the <code>public.books</code> table
     */
    fun books(): BooksPath {
        if (!this::_books.isInitialized) {
            _books = BooksPath(this, null, BOOKS__BOOKS_AUTHOR_ID_FKEY.inverseKey)
        }

        return _books
    }

    val books: BooksPath
        get(): BooksPath = books()
    override fun `as`(alias: String): Authors = Authors(DSL.name(alias), this)
    override fun `as`(alias: Name): Authors = Authors(alias, this)
    override fun `as`(alias: Table<*>): Authors = Authors(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Authors = Authors(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Authors = Authors(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Authors = Authors(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): Authors = Authors(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): Authors = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): Authors = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): Authors = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): Authors = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(
        @Stringly.SQL condition: String,
    ): Authors = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(
        @Stringly.SQL condition: String,
        vararg binds: Any?,
    ): Authors = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(
        @Stringly.SQL condition: String,
        vararg parts: QueryPart,
    ): Authors = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): Authors = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): Authors = where(DSL.notExists(select))
}