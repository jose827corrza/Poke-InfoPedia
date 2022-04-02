package com.josedev.pokedex.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toLowerCase
import com.josedev.pokedex.data.remote.responses.Type
import com.josedev.pokedex.data.remote.responses.Stat
import com.josedev.pokedex.ui.theme.*
import java.util.*

fun parseTypeToColor(type: Type): Color {
    return when(type.type.name.toLowerCase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseTypeToSpanish(type: Type): String{
    return when(type.type.name.toLowerCase(Locale.ROOT)){
        "normal" -> "Normal"
        "fire" -> "Fuego"
        "water" -> "Agua"
        "electric" -> "Electrico"
        "grass" -> "Hierba"
        "ice" -> "Hielo"
        "fighting" -> "Luchador"
        "poison" -> "Venenoso"
        "ground" -> "Tierra"
        "flying" -> "Volador"
        "psychic" -> "Psiquico"
        "bug" -> "Insecto"
        "rock" -> "Roca"
        "ghost" -> "Fantasma"
        "dragon" -> "Dragon"
        "dark" -> "Oscuro"
        "steel" -> "Acero"
        "fairy" -> "Hada"
        else -> ""
    }
}

fun parseStatToColor(stat: Stat): Color {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: Stat): String {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> "Puntos de vida"
        "attack" -> "Ataque"
        "defense" -> "Defensa"
        "special-attack" -> "Ataque especial"
        "special-defense" -> "Defensa especial"
        "speed" -> "Velocidad"
        else -> ""
    }
}