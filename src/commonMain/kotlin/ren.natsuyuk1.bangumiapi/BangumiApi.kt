package ren.natsuyuk1.bangumiapi

import kotlinx.atomicfu.AtomicRef
import kotlinx.atomicfu.atomic
import ren.natsuyuk1.bangumiapi.utils.HinaLogLevel
import ren.natsuyuk1.bangumiapi.utils.HinaLogger
import kotlin.native.concurrent.SharedImmutable

@SharedImmutable
internal val logger by lazy { HinaLogger("BangumiApi") }

public object BangumiApi {
    public val bangumiLogLevel: AtomicRef<HinaLogLevel> = atomic(HinaLogLevel.Info)
}