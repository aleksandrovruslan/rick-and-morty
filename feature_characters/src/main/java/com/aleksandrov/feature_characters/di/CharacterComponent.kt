package com.aleksandrov.feature_characters.di

import com.aleksandrov.core.BaseFragmentComponent
import com.aleksandrov.core.di.CoreComponentProvider
import com.aleksandrov.core.di.FeatureScope
import com.aleksandrov.core.di.ViewModelFactoryModule
import com.aleksandrov.feature_characters.CharactersFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [CharacterViewModelModule::class, ViewModelFactoryModule::class]
    , dependencies = [CoreComponentProvider::class]
)
interface CharacterComponent : BaseFragmentComponent<CharactersFragment> {

    @Component.Builder
    interface Builder {
        fun coreComponent(component: CoreComponentProvider): Builder
        fun build(): CharacterComponent
    }

}