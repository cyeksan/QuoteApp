package com.example.mvvmdemo.util

import kotlinx.coroutines.*

@DelicateCoroutinesApi
fun<T> lazyDeferred(block: suspend CoroutineScope.() -> T) : Lazy<Deferred<T>>{
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}