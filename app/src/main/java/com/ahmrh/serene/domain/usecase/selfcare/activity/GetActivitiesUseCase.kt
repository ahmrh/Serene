package com.ahmrh.serene.domain.usecase.selfcare.activity

import com.ahmrh.serene.common.utils.Category
import com.ahmrh.serene.common.state.ResourceState
import com.ahmrh.serene.data.repository.SelfCareRepository
import com.ahmrh.serene.domain.model.selfcare.SelfCareActivity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActivitiesUseCase @Inject constructor(
    private val selfCareRepository: SelfCareRepository
) {
    operator fun invoke(
        selfCareCategory: Category
    ): Flow<ResourceState<List<SelfCareActivity>>> =
        selfCareRepository.fetchActivities(selfCareCategory)

//    operator fun invoke(): Flow<ResourceState<List<SelfCareActivity>>> =
//        selfCareRepository.fetchActivities()

    operator fun invoke(
        listSelfCareCategory: List<Category>
    ): Flow<ResourceState<List<SelfCareActivity>>> =
        selfCareRepository.fetchActivities(listSelfCareCategory)


}