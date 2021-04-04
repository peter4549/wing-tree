package com.duke.orca.android.kotlin.wingtree.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.duke.orca.android.kotlin.wingtree.notification.data.NotificationItem
import com.duke.orca.android.kotlin.wingtree.study.data.Study
import com.duke.orca.android.kotlin.wingtree.util.EMPTY

class MainViewModel: ViewModel() {
    private val _selectedPostId = MutableLiveData<String>()
    val selectedPostId: LiveData<String>
        get() = _selectedPostId

    private val _selectedStudy = MutableLiveData<Study>()
    val selectedStudy: LiveData<Study>
        get() = _selectedStudy

    fun selectStudy(study: Study) {
        _selectedStudy.value = study
    }

    fun selectNotificationItem(notificationItem: NotificationItem) {
        _selectedPostId.value = notificationItem.postId
    }

    private val _allNotifications = MutableLiveData<List<NotificationItem>>()
    val allNotificationItems: LiveData<List<NotificationItem>>
        get() = _allNotifications

    private val _unconfirmedNotifications = MutableLiveData<List<NotificationItem>>()
    val unconfirmedNotificationItems: LiveData<List<NotificationItem>>
        get() = _unconfirmedNotifications

    /** Dummy Data */
    init {
        createDummyData()
    }

    private fun createDummyData() {
        val notifications = listOf(
            NotificationItem(
                action = "출근",
                confirmed = true,
                message = "반갑습니다.",
                postId = "POST_ID_000",
                profilePictureUrl = EMPTY,
                registrationTime = 0L,
                studyName = "Android"
            ),
            NotificationItem(
                action = "참여",
                confirmed = false,
                message = "참여하겠습니다.",
                postId = "POST_ID_001",
                profilePictureUrl = EMPTY,
                registrationTime = 0L,
                studyName = "OPIc"
            ),
            NotificationItem(
                action = "퇴근",
                confirmed = true,
                message = "퇴근합니다.",
                postId = "POST_ID_002",
                profilePictureUrl = EMPTY,
                registrationTime = 0L,
                studyName = "Cook"
            )
        )

        _allNotifications.value = notifications
        _unconfirmedNotifications.value = notifications.filter { it.confirmed.not() }
    }
}