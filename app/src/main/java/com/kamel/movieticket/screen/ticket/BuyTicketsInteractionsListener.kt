package com.kamel.movieticket.screen.ticket

interface BuyTicketsInteractionsListener {
    fun onClickExit()
    fun onClickBuy()
    fun doWhenSelectDay(day: Day)
    fun doWhenSelectHour(hour: String)
}