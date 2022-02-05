package ren.natsuyuk1.bangumikt.consts

/** Bangumi API 主网址 */
internal const val MAIN = "https://api.bgm.tv"

// ================ USER ================

/** 用户信息, 参数 username */
internal const val USER_INFO = "$MAIN/user"

/** 返回当前 Access Token 对应的用户信息 */
internal const val SELF_USER_INFO = "$MAIN/v0/me"

internal const val USER_COLLECTION = "$MAIN/v0/users/"