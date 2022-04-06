package com.moja.simplecleanarchitecture.domain

interface MessageUseCase {
    fun getMessage(name: String) : MessageEntity
}