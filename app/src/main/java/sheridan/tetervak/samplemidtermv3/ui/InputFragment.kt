package sheridan.tetervak.samplemidtermv3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.tetervak.samplemidtermv3.R
import sheridan.tetervak.samplemidtermv3.databinding.FragmentInputBinding
import sheridan.tetervak.samplemidtermv3.model.BreedInfo

class InputFragment : Fragment() {

    private val viewModel : BreedViewModel by activityViewModels()

    private lateinit var binding: FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInputBinding.inflate(inflater, container, false)
        binding.submitButton.setOnClickListener { showOutput() }
        return binding.root
    }

    private fun showOutput() {
        val breedName = binding.breedInput.text.toString().trim()
        if(breedName.isEmpty()){
            val required = getString(R.string.required)
            binding.breedInput.error = required
            Toast.makeText(context, required, Toast.LENGTH_LONG).show()
        }else{
            val hairList = resources.getStringArray(R.array.hair_list)
            val hairLength = hairList[binding.hairInput.selectedItemPosition]
            val breedInfo = BreedInfo(breedName, hairLength)
            viewModel.submit(breedInfo)
            findNavController().navigate(R.id.action_input_to_output)
        }
    }


}