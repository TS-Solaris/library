/*
 * This file is generated by jOOQ.
 */
package org.example.library.infra.jooq.tables.records

import org.example.library.infra.jooq.tables.Authors
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl
import java.time.OffsetDateTime
import java.util.UUID

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class AuthorsRecord private constructor() : UpdatableRecordImpl<AuthorsRecord>(Authors.AUTHORS) {
    open var id: UUID
        set(value): Unit = set(0, value)
        get(): UUID = get(0) as UUID

    open var name: String
        set(value): Unit = set(1, value)
        get(): String = get(1) as String

    open var createdAt: OffsetDateTime?
        set(value): Unit = set(2, value)
        get(): OffsetDateTime? = get(2) as OffsetDateTime?

    open var updatedAt: OffsetDateTime?
        set(value): Unit = set(3, value)
        get(): OffsetDateTime? = get(3) as OffsetDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<UUID?> = super.key() as Record1<UUID?>

    /**
     * Create a detached, initialised AuthorsRecord
     */
    constructor(id: UUID, name: String, createdAt: OffsetDateTime?, updatedAt: OffsetDateTime?) : this() {
        this.id = id
        this.name = name
        this.createdAt = createdAt
        this.updatedAt = updatedAt
        resetChangedOnNotNull()
    }
}
