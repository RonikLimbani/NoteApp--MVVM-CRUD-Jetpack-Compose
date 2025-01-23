package com.ronik.noteapp.domain.util



sealed class OrderType {
     object Ascending: OrderType()
     object Descending: OrderType()
}