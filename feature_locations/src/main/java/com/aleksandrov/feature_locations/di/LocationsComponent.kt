package com.aleksandrov.feature_locations.di

import com.aleksandrov.core.BaseFragmentComponent
import com.aleksandrov.core.di.CoreComponentProvider
import com.aleksandrov.core.di.FeatureScope
import com.aleksandrov.core.di.ViewModelFactoryModule
import com.aleksandrov.feature_locations.LocationsFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [ViewModelFactoryModule::class, LocationsViewModelModule::class]
    , dependencies = [CoreComponentProvider::class]
)
interface LocationsComponent : BaseFragmentComponent<LocationsFragment> {

    @Component.Builder
    interface Builder {
        fun coreComponent(component: CoreComponentProvider): Builder
        fun build(): LocationsComponent
    }

}