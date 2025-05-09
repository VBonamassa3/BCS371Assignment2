package com.example.assignment2

class BookRepository(
    private val appName:String = "Book App",
    private val appDeveloperName:String = "Vincent Bonamassa",
    private val appVersion:String = "1.0",
    private val bookList:MutableList<Book> = mutableListOf(
        Book("Joy Buolamwini Biography: Championing Humanity in the Age of AI", "Biography", 16.96),
        Book("Ada Lovelace: A Life from Beginning to End", "Biography", 9.99),
        Book("Alan Turing: The Enigma", "Biography", 8.50),
        Book("Trust", "Science Fiction", 10.17),
        Book("Dark Matter", "Science Fiction", 9.16),
        Book("The Midnight Library", "Science Fiction", 9.54),
        Book("Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones", "Self-help", 15.00),
        Book("Happiness is Choice", "Self-help", 15.00),
        Book("Get Out of Your Head: Stopping the Spiral of Toxic Thoughts", "Self-help", 13.73)
    )
)
{
    fun getAppData(): String {
        return appName
    }
    fun getAppDeveloperName(): String {
        return appDeveloperName
    }
    fun getAppVersion(): String {
        return appVersion
    }
    fun getBooks(): MutableList<Book> {
        return bookList
    }
    fun getAveragePrice(): Double{
        val average = bookList.map { it.price }.average()
        return average
    }
    fun getGenreAveragePrice(genre: String): Double{
        val bookGenres = bookList.filter { it.genre == genre }
        val average = bookGenres.map { it.price }.average()
        return average
    }
}