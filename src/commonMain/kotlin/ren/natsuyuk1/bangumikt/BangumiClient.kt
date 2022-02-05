package ren.natsuyuk1.bangumikt

import io.ktor.client.*
import kotlinx.coroutines.CoroutineName
import ren.natsuyuk1.bangumikt.consts.getDefaultHttpClient
import kotlin.coroutines.CoroutineContext

/**
 * [BangumiClient]
 *
 * Bangumi API 的请求客户端
 * 所有可用 API 请参见 [ren.natsuyuk1.bangumikt.api]
 * 且均为扩展方法
 *
 * @param client [HttpClient]
 * @param context 协程上下文
 *
 */
public class BangumiClient(
    public var client: HttpClient = getDefaultHttpClient(),
    public val context: CoroutineContext = PlatformDispatcher.ioDispatcher + CoroutineName("yabapi")
) {
}