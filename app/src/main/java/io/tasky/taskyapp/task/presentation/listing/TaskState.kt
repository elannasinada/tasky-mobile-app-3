package io.tasky.taskyapp.task.presentation.listing

import io.tasky.taskyapp.task.domain.model.Task

data class TaskState(
    val tasks: List<Task> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null,
    val showPremiumDialog: Boolean = false
)