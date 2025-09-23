package `in`.sethiya.bizzbots.bfsi.finces.merchant.model

import androidx.room.Dao
import androidx.room.Query
@Dao
interface FencesMerchant {
    @Query("SELECT COUNT(*) FROM users")
    suspend fun getUsersCount(): Int
}