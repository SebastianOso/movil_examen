package com.app.movil_examen.domain.usecase

import com.app.movil_examen.domain.model.Country
import com.app.movil_examen.domain.common.Result
import com.app.movil_examen.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCountriesStory
@Inject
constructor(
    private val repository: CountryRepository,
) {
    operator fun invoke(): Flow<Result<List<Country>>> =
        flow {
            try {
                emit(Result.Loading)
                val movieList = repository.getCountryList()
                emit(Result.Success(movieList))
            } catch (e: Exception) {
                emit(Result.Error(e))
            }
        }
}