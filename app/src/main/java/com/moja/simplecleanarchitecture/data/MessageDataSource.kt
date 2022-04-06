package com.moja.simplecleanarchitecture.data

import com.moja.simplecleanarchitecture.domain.MessageEntity

class MessageDataSource : IMessageDataSource {
    override fun getMessageFromSource(name: String): MessageEntity =
        MessageEntity("Hello $name! This is simple clean architecture")
}