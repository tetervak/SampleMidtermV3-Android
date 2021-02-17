package sheridan.tetervak.samplemidtermv3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sheridan.tetervak.samplemidtermv3.R
import sheridan.tetervak.samplemidtermv3.databinding.FragmentOutputBinding
import sheridan.tetervak.samplemidtermv3.model.BreedInfo

class OutputFragment : Fragment() {

    companion object{
        const val BREED_INFO = "breed_info"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOutputBinding.inflate(inflater, container, false)
        binding.breedInfo = arguments?.getSerializable(BREED_INFO) as BreedInfo
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_output_to_input)
        }
        return binding.root
    }

}