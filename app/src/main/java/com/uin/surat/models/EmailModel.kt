package com.uin.surat.models

data class EmailModel (val senderImage: Int, val senderEmail: String, val titleEmail: String, val descriptionEmail: String,
                       val timeEmail: String?, val dateEmail: String?, val isFavorite: Boolean )

