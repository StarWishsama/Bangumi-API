package ren.natsuyuk1.bangumikt.consts

import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*

actual fun getDefaultEngine(): HttpClientEngineFactory<*> = CIO