package sheridan.tetervak.samplemidtermv3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.tetervak.samplemidtermv3.R
import sheridan.tetervak.samplemidtermv3.databinding.FragmentOutputBinding

class OutputFragment : Fragment() {

    private val viewModel : BreedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOutputBinding.inflate(inflater, container, false)

        viewModel.breedInfoData.observe(viewLifecycleOwner){
            binding.breedOutput.text = it.breedName
            binding.hairOutput.text = it.hairLength
        }

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_output_to_input)
        }
        return binding.root
    }

}