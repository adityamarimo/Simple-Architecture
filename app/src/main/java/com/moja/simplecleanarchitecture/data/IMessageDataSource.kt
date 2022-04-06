package com.moja.simplecleanarchitecture.data

import com.moja.simplecleanarchitecture.domain.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}