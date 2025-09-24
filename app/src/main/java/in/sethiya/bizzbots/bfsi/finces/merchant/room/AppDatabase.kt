package `in`.sethiya.bizzbots.bfsi.finces.merchant.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import `in`.sethiya.bizzbots.bfsi.finces.merchant.model.MerchantUsers

@Database(entities = [MerchantUsers::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun fencesMerchantDao(): FencesMerchantDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "merchant_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}