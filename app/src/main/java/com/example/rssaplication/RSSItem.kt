package com.example.rssaplication

data class RSSItem(
    val title: String,
    val text: String,
    val type: RSSType,
    val media: Int? = R.drawable.baseline_hide_image_24
)

enum class RSSType {
    TEXT,
    VIDEO,
    Image
}
