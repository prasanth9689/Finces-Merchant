package `in`.sethiya.bizzbots.bfsi.finces.merchant.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FencesMerchantDao {
    @Query("SELECT COUNT(*) FROM users")
    suspend fun getUsersCount(): Int
}