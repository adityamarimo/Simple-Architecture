package com.moja.simplecleanarchitecture.di

import com.moja.simplecleanarchitecture.data.IMessageDataSource
import com.moja.simplecleanarchitecture.data.MessageDataSource
import com.moja.simplecleanarchitecture.data.MessageRepository
import com.moja.simplecleanarchitecture.domain.IMessageRepository
import com.moja.simplecleanarchitecture.domain.MessageInteractor
import com.moja.simplecleanarchitecture.domain.MessageUseCase

object Injection {
    fun provideUseCase(): MessageUseCase {
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource {
        return MessageDataSource()
    }
}