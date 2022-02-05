package ren.natsuyuk1.bangumikt.consts

import io.ktor.client.engine.*

actual fun getDefaultEngine(): HttpClientEngineFactory<*> = Curl