package org.example.library.presentation.author

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthorRequest(
    @JsonProperty("name") val name: String,
)
