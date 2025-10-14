package com.app.movil_examen.domain.usecase

import com.app.movil_examen.domain.common.Result
import com.app.movil_examen.domain.model.Country
import com.app.movil_examen.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCountryStory
@Inject
constructor(
    private val repository: CountryRepository,
) {
    operator fun invoke(name: String): Flow<Result<Country>> =
        flow {
            try {
                emit(Result.Loading)
                val movie = repository.getCountryById(name)
                emit(Result.Success(movie))
            } catch (e: Exception) {
                emit(Result.Error(e))
            }
        }
}