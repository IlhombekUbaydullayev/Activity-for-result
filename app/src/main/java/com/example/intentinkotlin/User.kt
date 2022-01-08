package com.example.intentinkotlin

import java.io.Serializable

class User (id : Int,name : String): Serializable {
    var id : Int = id
    var name : String = name
    override fun toString(): String {
        return "id  = $id , name = $name"
    }
}