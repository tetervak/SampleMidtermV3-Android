package sheridan.tetervak.samplemidtermv3.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sheridan.tetervak.samplemidtermv3.model.BreedInfo

class BreedViewModel : ViewModel(){

    private val _breedInfoData: MutableLiveData<BreedInfo> = MutableLiveData()
    val breedInfoData: LiveData<BreedInfo> = _breedInfoData

    fun submit(breedInfo: BreedInfo){
        _breedInfoData.value = breedInfo
    }

}