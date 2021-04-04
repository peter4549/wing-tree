package com.duke.orca.android.kotlin.wingtree.notification.data

data class NotificationItem(
    val action: String,
    var confirmed: Boolean,
    val message: String,
    val postId: String,
    val profilePictureUrl: String,
    val registrationTime: Long,
    val studyName: String,
)