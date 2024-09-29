package com.example.book.library.domain.usecase

import com.example.book.library.domain.IRemoteRepository
import com.example.book.library.domain.model.BookListDataItem
import com.example.book.library.presentation.authentication.common.getYearFromEpoch
import java.util.Calendar
import javax.inject.Inject

class FetchBooksListUsecase @Inject constructor(private val iRemoteRepository: IRemoteRepository) {


    suspend operator fun invoke(): Map<Int, List<BookListDataItem>> {
        val data = iRemoteRepository.getBookList()
        val mappedData = mappedDataYearWise(data)
        return mappedData
    }

    private fun mappedDataYearWise(data: List<BookListDataItem>): Map<Int, List<BookListDataItem>> {
        return data.groupBy { item ->
            getYearFromEpoch(item.publishedChapterDate)
        }.toSortedMap(compareByDescending { it })
    }



}