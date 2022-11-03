package com.example.lib


const val ZERO =0
fun  outerFun(){
    print("I am outerFun" )
}
open class Lesson15 {

//    val country =""
//      var city = ""
//     var  address:String =" "

    companion object {
        @JvmStatic fun main(args: Array<String>) {

val kotlinClass = KotlinClass("Igor", 33)
val kotlinClass2 = KotlinClass("country"," Vitebsk","Petrova 16")
            println("${kotlinClass2.country} ${kotlinClass2.city} ${kotlinClass2.address} ")


            val  string = kotlinClass.getNameAndAge()
            println(string)

            val lesson15 = Lesson15()
      //      lesson15.country = " cant change"
//            lesson15.city = " Brest"
//            lesson15.address = "Smolechkova 16 "
//            println("${lesson15.address}")

outerFun()


        }
    }


    fun  emptyFun(){
        print(" I am an empty fun")

    }

    fun  returnBoolean(): Boolean = true

}

class  KotlinClass (val name:String, var age:Int):Parent(), Behavior{

    public var country = ""
    public var city = ""
    public var  address =" "

    constructor(): this("",25)
    constructor(country:String, city:String, address:String):this(){
        this.country = country
        this.city = city
        this.address = address




    }


    fun  getNameAndAge():String{
        age =12
        return "$name \n $age"


    }

    override fun getHairColor() {
        super.getHairColor()
    }

    override fun getEyeColor() {
        TODO("Not yet implemented")
    }
}
open class  Parent{

  open  fun  getHairColor(){


    }
}

interface Behavior{

    fun  getEyeColor()

}