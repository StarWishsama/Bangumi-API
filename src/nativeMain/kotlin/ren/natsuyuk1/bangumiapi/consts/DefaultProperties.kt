package ren.natsuyuk1.bangumiapi.consts

import io.ktor.client.engine.*

actual fun getDefaultEngine(): HttpClientEngineFactory<*> = Curl