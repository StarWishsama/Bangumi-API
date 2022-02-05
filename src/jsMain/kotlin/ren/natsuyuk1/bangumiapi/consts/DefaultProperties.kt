package ren.natsuyuk1.bangumiapi.consts

import io.ktor.client.engine.*
import io.ktor.client.engine.js.*

actual fun getDefaultEngine(): HttpClientEngineFactory<*> = Js