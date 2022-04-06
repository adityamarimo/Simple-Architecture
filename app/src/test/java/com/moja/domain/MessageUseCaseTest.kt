package com.moja.domain

import com.moja.simplecleanarchitecture.domain.IMessageRepository
import com.moja.simplecleanarchitecture.domain.MessageEntity
import com.moja.simplecleanarchitecture.domain.MessageInteractor
import com.moja.simplecleanarchitecture.domain.MessageUseCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MessageUseCaseTest {

    private lateinit var messageUseCase: MessageUseCase

    @Mock
    private lateinit var messageRepository: IMessageRepository

    @Before
    fun setUp() {
        messageUseCase = MessageInteractor(messageRepository)
        val dummyMessage = MessageEntity("Hello $NAME! This is simple clean architecture")
        `when`(messageRepository.getWelcomeMessage(NAME)).thenReturn(dummyMessage)
    }

    @Test
    fun `should get data from repository`() {
        val message = messageUseCase.getMessage(NAME)

        verify(messageRepository).getWelcomeMessage(NAME)
        verifyNoMoreInteractions(messageRepository)
        Assert.assertEquals("Hello $NAME! This is simple clean architecture", message.welcomeMessage)
    }

    companion object {
        const val NAME = "Aditya Salman"
    }
}