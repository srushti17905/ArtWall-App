package com.example.my_shayari_app

import Category
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import cafe.adriel.voyager.transitions.SlideTransition

var context: Any? = null

@Composable
fun myapp(getcontext: Any? = null) {

    context = getcontext
    Navigator(Category()) { navigator ->

        SlideTransition(navigator = navigator, animationSpec = tween(1000))

//        FadeTransition(navigator, animationSpec = tween(2000))

    }
}