package com.ahmrh.serene.ui.screen.main.home

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmrh.serene.common.Category
import com.ahmrh.serene.common.state.UiState
import com.ahmrh.serene.data.repository.PreferencesRepository
import com.ahmrh.serene.domain.model.SelfCareActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val preferencesRepository: PreferencesRepository
): ViewModel() {


    private var _selfCareStartedUiState: MutableStateFlow<Boolean> =
        MutableStateFlow(false)

    val selfCareStartedUiState: StateFlow<Boolean>
        get() = _selfCareStartedUiState

    private  var _startedActivityIdState: MutableStateFlow<String?> =
        MutableStateFlow(null)

    val startedActivityIdState: StateFlow<String?>
        get() = _startedActivityIdState


    private var _personalizationResultState: MutableStateFlow<Category?> =
        MutableStateFlow(null)

    val personalizationResultState: StateFlow<Category?>
        get() = _personalizationResultState


    init {
        viewModelScope.launch {
            // get data

            preferencesRepository.getStartedActivityIdValue().collect{
                _selfCareStartedUiState.value = it != null
                _startedActivityIdState.value = it
            }

            preferencesRepository.getPersonalizationResultValue().collect{
                _personalizationResultState.value  = it
            }
        }
    }


    fun addSelfCareStartedValue() {
        viewModelScope.launch {
            preferencesRepository.changeStartedActivityIdValue("random id goes brr")
        }
    }

    fun changeSelfCareStartedValue(boolean: Boolean){
        viewModelScope.launch {
            preferencesRepository.changeSelfCareStartedValue(boolean);
            preferencesRepository.changeStartedActivityIdValue("random id goes brr")
        }
    }


}