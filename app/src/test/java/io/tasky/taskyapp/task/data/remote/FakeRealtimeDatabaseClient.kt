package io.tasky.taskyapp.task.data.remote

import io.tasky.taskyapp.core.util.Resource
import io.tasky.taskyapp.sign_in.domain.model.UserData
import io.tasky.taskyapp.task.domain.model.Task
import io.tasky.taskyapp.task.domain.use_cases.task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRealtimeDatabaseClient : RealtimeDatabaseClient {
    private val tasks = mutableListOf(task())
    override suspend fun deleteTask(user: UserData, task: Task) {
        tasks.remove(task)
    }

    override fun getTasksFromUser(user: UserData): Flow<Resource<List<Task>>> = flow {
        emit(
            Resource.Success(
                data = tasks.sortedWith(
                    compareBy(
                        Task::deadlineDate,
                        Task::deadlineTime,
                        Task::title,
                    )
                )
            )
        )
    }

    override suspend fun insertTask(user: UserData, task: Task) {
        with(tasks) {
            val filteredList = filter { task.uuid == it.uuid }

            if (filteredList.isNotEmpty()) {
                val index = indexOf(filteredList.first())
                removeAt(index)
                add(index, task)
            } else {
                add(task)
            }
        }
    }
}
