package com.duke.orca.android.kotlin.wingtree.user.data

import com.duke.orca.android.kotlin.wingtree.util.EMPTY

data class User (
    var company: String = EMPTY,
    var department: String = EMPTY,
    var email: String = EMPTY,
    val id: String,
    var name: String,
    var phoneNumber: String = EMPTY,
    var position: String = EMPTY,
    var profilePictureUrl: String = EMPTY,
)