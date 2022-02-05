package ren.natsuyuk1.bangumikt.api

import io.ktor.client.request.*
import kotlinx.coroutines.withContext
import ren.natsuyuk1.bangumikt.BangumiClient
import ren.natsuyuk1.bangumikt.consts.USER_INFO
import ren.natsuyuk1.bangumikt.data.user.UserInfoData
import ren.natsuyuk1.bangumikt.deserializeJson
import ren.natsuyuk1.bangumikt.logger

/**
 * 获取用户信息
 *
 * @param username 用户名/UID
 */
public suspend fun BangumiClient.getUserInfo(
    username: String
): UserInfoData? = withContext(context) {
    logger.debug("Getting user info for $username")
    client.get<String>("$USER_INFO/$username")
        .deserializeJson<UserInfoData?>().also {
        logger.debug("Parsed user info of $username")
    }
}