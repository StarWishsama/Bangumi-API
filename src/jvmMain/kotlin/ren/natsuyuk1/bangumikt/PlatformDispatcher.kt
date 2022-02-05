package ren.natsuyuk1.bangumikt

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual object PlatformDispatcher {
    actual val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
}