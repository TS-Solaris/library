package org.example.library.domain.author

import java.util.UUID

data class Author(
    val id: UUID,
    val name: String,
) {
    companion object {
        private const val MAX_NAME_LENGTH = 255
    }

    constructor(name: String) : this(UUID.randomUUID(), name)

    init {
        require(name.isNotBlank() && name.length <= MAX_NAME_LENGTH) { "著者名は1文字以上255文字以下で入力してください" }
    }
}
