package com.example.jetnumbers.domain.usecases

import com.example.jetnumbers.domain.entity.GameSettings
import com.example.jetnumbers.domain.entity.Question
import com.example.jetnumbers.domain.repository.GameRepository

class GenerateQuestionsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int):Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object{
        private const val COUNT_OF_OPTIONS = 6
    }
}