package com.example.jetnumbers.domain.repository

import com.example.jetnumbers.domain.entity.GameSettings
import com.example.jetnumbers.domain.entity.Level
import com.example.jetnumbers.domain.entity.Question
import com.example.jetnumbers.domain.usecases.GenerateQuestionsUseCase

interface GameRepository {
    fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question
    fun getGameSettings(level: Level): GameSettings
}