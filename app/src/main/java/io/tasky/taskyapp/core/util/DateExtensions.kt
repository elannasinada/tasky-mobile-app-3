package io.tasky.taskyapp.core.util

import java.text.SimpleDateFormat
import java.util.Locale

fun dateToString(
    day: Int,
    month: Int,
    year: Int,
): String {
    val date = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
        .parse("$day-${month + 1}-$year")!!
    return SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(date)
}

fun timeToString(
    hour: Int,
    minute: Int,
): String {
    val date = SimpleDateFormat("HH:mm", Locale.ENGLISH)
        .parse("$hour:$minute")!!
    return SimpleDateFormat("HH:mm", Locale.ENGLISH).format(date)
}
