package `in`.sethiya.bizzbots.bfsi.finces.merchant.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class MerchantUsers(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val contactId: String,
    val firstName: String,
    val phoneNumber: String
)
