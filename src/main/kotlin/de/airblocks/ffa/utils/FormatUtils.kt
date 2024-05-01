package de.airblocks.ffa.utils

fun getTimeAsString(time: Int): String {
    val minutes = time % 3600 / 60
    val seconds = time % 60
    return String.format("%02d:%02d ", minutes, seconds)
}