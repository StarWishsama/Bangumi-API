package ren.natsuyuk1.bangumikt.data.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ren.natsuyuk1.bangumikt.data.BangumiData

@Serializable
public data class UserInfoData(
    val id: Int,
    val url: String,
    val username: String,
    val nickname: String,
    val avatar: AvatarItem? = null,
    @SerialName("sign")
    val bio: String? = null,
    @SerialName("usergroup")
    val userGroup: Int
): BangumiData {
    @Serializable
    public data class AvatarItem(
        val large: String,
        val medium: String,
        val small: String
    )
}
