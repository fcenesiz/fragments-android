package com.fcenesiz.send_data_with_green_robot.event

data class DataEvent(
    private val number1: Int,
    private val number2: Int
) {
    val n1: Int = number1
    val n2: Int = number2
}