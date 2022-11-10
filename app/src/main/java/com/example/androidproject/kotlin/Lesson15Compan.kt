package com.example.androidproject.kotlin

class Lesson15Compan {
    companion object{


        @JvmStatic
        fun main(args: Array<String>) {

val  first = First().navigate()
            val  second = First.walk()


        }

    }


}

class  First {

    fun navigate() {
        print("navigating...")

    }


    companion object {
        fun walk() {

            print("Im walking")
        }


    }
}