package `in`.sethiya.bizzbots.bfsi.finces.merchant

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.sethiya.bizzbots.bfsi.finces.merchant.repository.PanRepository
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PanModule {

    @Provides
    @Named("clientId")
    fun provideClientId(): String = "YOUR_CLIENT_ID"

    @Provides
    @Named("clientSecret")
    fun provideClientSecret(): String = "YOUR_CLIENT_SECRET"

    @Provides
    @Singleton
    fun providePanRepository(
        @Named("clientId") clientId: String,
        @Named("clientSecret") clientSecret: String
    ): PanRepository = PanRepository(clientId, clientSecret)
}
