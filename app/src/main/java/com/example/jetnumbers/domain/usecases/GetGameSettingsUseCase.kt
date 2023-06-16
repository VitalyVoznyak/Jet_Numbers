package com.example.jetnumbers.domain.usecases

import com.example.jetnumbers.domain.entity.GameSettings
import com.example.jetnumbers.domain.entity.Level
import com.example.jetnumbers.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level):GameSettings{
        return repository.getGameSettings(level)
    }
}