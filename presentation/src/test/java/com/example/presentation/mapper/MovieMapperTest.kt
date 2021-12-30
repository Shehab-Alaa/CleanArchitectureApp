package com.example.presentation.mapper

import com.example.presentation.model.generateDomainModel
import com.example.presentation.model.generatePresentationModel
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieMapperTest{

    private val movieMapper = MovieMapper()

    @Test
    fun `map from domain to presentation` () {

        val domainModel = generateDomainModel()
        val expectedPresentationModel = generatePresentationModel()

        val presentationModel = movieMapper.mapToPresentation(domainModel)

        assertEquals(expectedPresentationModel.id,presentationModel.id)
        assertEquals(expectedPresentationModel.title,presentationModel.title)
        assertEquals(expectedPresentationModel.voteAverage,presentationModel.voteAverage)
        assertEquals(expectedPresentationModel.voteCount,presentationModel.voteCount)
        assertEquals(expectedPresentationModel.backdropPath,presentationModel.backdropPath)
        assertEquals(expectedPresentationModel.posterPath,presentationModel.posterPath)
        assertEquals(expectedPresentationModel.releaseDate,presentationModel.releaseDate)
    }

    @Test
    fun `map from presentation to domain`  (){

        val presentationModel = generatePresentationModel()
        val expectedDomainModel = generateDomainModel()

        val domainModel = movieMapper.mapToDomain(presentationModel)

        assertEquals(expectedDomainModel.id,domainModel.id)
        assertEquals(expectedDomainModel.title,domainModel.title)
        assertEquals(expectedDomainModel.voteAverage,domainModel.voteAverage)
        assertEquals(expectedDomainModel.voteCount,domainModel.voteCount)
        assertEquals(expectedDomainModel.backdropPath,domainModel.backdropPath)
        assertEquals(expectedDomainModel.posterPath,domainModel.posterPath)
        assertEquals(expectedDomainModel.releaseDate,domainModel.releaseDate)
    }


}