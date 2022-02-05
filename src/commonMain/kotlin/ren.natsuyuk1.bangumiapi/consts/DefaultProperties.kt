package ren.natsuyuk1.bangumiapi.consts

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.*
import io.ktor.client.features.cookies.*
import io.ktor.client.request.*
import io.ktor.http.*

public expect fun getDefaultEngine(): HttpClientEngineFactory<*>

/**
 * 根据平台选择默认的 HttpClient
 * @see getDefaultEngine
 */
public fun getDefaultHttpClient(
    cookiesStorage: CookiesStorage = AcceptAllCookiesStorage(),
): HttpClient =
    HttpClient(getDefaultEngine()) {
        install(UserAgent) {
            agent = DEFAULT_USER_AGENT
        }
        install(HttpCookies) {
            storage = cookiesStorage
        }
        defaultRequest {
            header(HttpHeaders.Accept, "*/*")
            header(HttpHeaders.AcceptCharset, "UTF-8")
        }
    }

internal const val DEFAULT_USER_AGENT: String =
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.80 Safari/537.36 Edg/98.0.1108.43"