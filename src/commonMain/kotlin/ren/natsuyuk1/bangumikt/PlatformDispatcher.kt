package ren.natsuyuk1.bangumikt

import kotlinx.coroutines.CoroutineDispatcher

internal expect object PlatformDispatcher {
    val ioDispatcher: CoroutineDispatcher
}