package com.example.androidproject.kotlin

class Lesson16 {

    val number:Int? = null
    val name:String? = null

    val nullable:Int? =null

    companion object{

        @JvmStatic
        fun main(args: Array<String>) {
//            val  lesson16 = Lesson16()
//            var nonNullableValue: Int = 10     // не нал переменная
//
//            val  nullableValue: Int? =null // это нал переменная

//            if (nullableValue!=null){ //  проверяю что не нал переменная
//                nonNullableValue =nullableValue
//
//            }
//            else{// а тут нал наша нал переменная
//                nonNullableValue = nullableValue


//            }
//            nullableValue?.let { nonNullableValue = it } // проверка на нал
//
//            val values= Values(0, "name")
//
//            print(values.name)
//
//                         nonNullableValue = nullableValue?:0 // элвис оператор
//
//            nonNullableValue = nullableValue!!
//
//            print(nonNullableValue)


            val outer = Outer(Inner("value in inner"))
            val value:String = outer.inner?.value ?: ""






        }
    }

}

data class  Values(val number: Int,
val name:String?="have no string"
 )

data class  Outer(val inner:Inner?)
data class  Inner(val value:String)