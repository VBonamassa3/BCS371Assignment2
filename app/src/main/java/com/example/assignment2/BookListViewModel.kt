package com.example.assignment2

import androidx.lifecycle.ViewModel

class BookListViewModel(var bookListRepository: BookRepository) : ViewModel() {
    fun obtainBooks(): MutableList<Book>{
        return bookListRepository.getBooks()
    }
}