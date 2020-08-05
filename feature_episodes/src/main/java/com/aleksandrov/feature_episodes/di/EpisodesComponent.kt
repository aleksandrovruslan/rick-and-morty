package com.aleksandrov.feature_episodes.di

import com.aleksandrov.core.BaseFragmentComponent
import com.aleksandrov.core.di.CoreComponentProvider
import com.aleksandrov.core.di.FeatureScope
import com.aleksandrov.core.di.ViewModelFactoryModule
import com.aleksandrov.feature_episodes.EpisodesFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [ViewModelFactoryModule::class, EpisodesViewModelModule::class]
    , dependencies = [CoreComponentProvider::class]
)
interface EpisodesComponent : BaseFragmentComponent<EpisodesFragment> {

    @Component.Builder
    interface Builder {
        fun coreComponent(component: CoreComponentProvider): Builder
        fun build(): EpisodesComponent
    }

}