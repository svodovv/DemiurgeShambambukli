package com.example.demiurgeshambambukli.presentation.ui.screens.cellular

enum class CellularImageItem(
    val imageUrl: String,
    val title: String,
    val description: String
) {
    DEAD(
        imageUrl = "https://cdn3.iconfinder.com/data/icons/glypho-generic-icons/64/skull-1024.png",
        title = "Мёртвая",
        description = "или прикидывается"
    ),
    ALIVE(
        imageUrl = "https://cdn-icons-png.flaticon.com/512/9293/9293840.png",
        title = "Живая",
        description = "и шевелится!"
    ),
    LIFE(
        imageUrl = "https://cdn-icons-png.flaticon.com/512/2773/2773104.png",
        title = "Жизнь",
        description = "Ку-ку!"
    ),
    DEATH(
        imageUrl = "https://cdn3.iconfinder.com/data/icons/medical-6-1/512/mortuary_tag_morgue_dead_room-1024.png",
        title = "Смерть",
        description = "видимо не прикидывается"
    )

}