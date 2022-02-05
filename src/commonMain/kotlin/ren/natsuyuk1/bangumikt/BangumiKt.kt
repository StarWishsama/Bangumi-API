package ren.natsuyuk1.bangumikt

import kotlinx.atomicfu.AtomicRef
import kotlinx.atomicfu.atomic
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import ren.natsuyuk1.bangumikt.utils.HinaLogLevel
import ren.natsuyuk1.bangumikt.utils.HinaLogger
import kotlin.native.concurrent.SharedImmutable

@SharedImmutable
internal val logger by lazy { HinaLogger("BangumiApi") }

public object BangumiApi {
    public val defaultJson: AtomicRef<Json> = atomic(Json {
        prettyPrint = true
        isLenient = true
        coerceInputValues = true
    })

    public val bangumiLogLevel: AtomicRef<HinaLogLevel> = atomic(HinaLogLevel.Info)
}

internal inline fun <reified T> String.deserializeJson(): T {
    return BangumiApi.defaultJson.value.decodeFromString(this)
}