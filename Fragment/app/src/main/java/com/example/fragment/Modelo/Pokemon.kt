package com.example.fragment.Modelo

data class Pokemon(var id : Int , var nombre : String, var tipo : TypePokemon,var imgUrl: String) {
    enum class TypePokemon {
        fuego, aire , agua, tierra
    }
}