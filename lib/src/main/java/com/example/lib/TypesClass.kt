package com.example.lib

class TypesClass {
    companion object{

        @JvmStatic
        fun main(args: Array<String>) {
//unmutable collection
val  collectionList =  listOf<String>("hello", "bye", "world")




   // mutable collection
        val collectionList2 = mutableListOf<String>()
            collectionList2.add("hello")
            collectionList2.add("bye")
            collectionList2.add("world")

collectionList.forEach{ world-> print("$world") }

           for (i in 1..collectionList.size){
               print(i)

           }


            val arrayList = arrayListOf<String>("hello", "Minsk", "World")

            for (word in arrayList){
                println(word)
            }


            for (i in 10 downTo  1 step 2){
                println("$i")

            }

            for (i in 1 ..10){

                if (i==2){
                    print("Hello World")
                    continue

                }
                print(i)

            }
val typesClass = TypesClass()
repeat(10){

    println(typesClass.getName())
}


   // Приведение типов
//            val  child:Child = Child()
//
//
//            val parent2 = child as Parent2
//
//            if (parent2 is Parent2){
//                parent2.sleep()
//                child.walk()
//
//            }
//
//            if (parent2 is Child){
//                parent2.sleep()
//                parent2.walk()
//
//            }


        }

    }

fun  getName():String{

    return "Hello!!!"
}


}

open class  Parent2{

    open  fun walk(){

        print("Parent is walking..")

    }


}

class  Child:Parent2(){

    override fun walk() {
     print("Child is walking")
    }


    fun  sleep(){

        print("Child is sleeping")

    }



}