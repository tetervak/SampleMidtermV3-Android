package sheridan.tetervak.samplemidtermv3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import sheridan.tetervak.samplemidtermv3.R
import sheridan.tetervak.samplemidtermv3.databinding.FragmentInputBinding
import sheridan.tetervak.samplemidtermv3.model.BreedInfo

class InputFragment : Fragment() {

    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInputBinding.inflate(inflater, container, false)
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
            val action = InputFragmentDirections.actionInputToOutput(breedInfo)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}