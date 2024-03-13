package com.objective.objectnet.model

data class MessageRequest(
    val sender: String,
    val receiver: String,
    val content: String
)