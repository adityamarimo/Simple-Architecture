package com.moja.simplecleanarchitecture.data

import com.moja.simplecleanarchitecture.domain.IMessageRepository
import com.moja.simplecleanarchitecture.domain.MessageEntity

class MessageRepository(private val messageDataSource: IMessageDataSource) : IMessageRepository {
    override fun getWelcomeMessage(name: String): MessageEntity =
        messageDataSource.getMessageFromSource(name)
}