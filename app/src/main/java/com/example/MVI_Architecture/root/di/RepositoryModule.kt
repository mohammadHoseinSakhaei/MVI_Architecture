package com.example.MVI_Architecture.root.di

import com.example.MVI_Architecture.root.datasource.LocalBlogDataSource
import com.example.MVI_Architecture.root.datasource.RemoteBlogDataSource
import com.example.MVI_Architecture.root.local.LocalMapper
import com.example.MVI_Architecture.root.remote.RemoteMapper
import com.example.MVI_Architecture.root.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponentManager::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        remoteBlogDataSource: RemoteBlogDataSource,
        localBlogDataSource: LocalBlogDataSource,
        remoteMapper: RemoteMapper,
        localMapper: LocalMapper
    ): MainRepository {
        return MainRepository(remoteBlogDataSource, localBlogDataSource, remoteMapper, localMapper)
    }
}