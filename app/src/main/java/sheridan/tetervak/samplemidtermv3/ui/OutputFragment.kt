package sheridan.tetervak.samplemidtermv3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import sheridan.tetervak.samplemidtermv3.databinding.FragmentOutputBinding

class OutputFragment : Fragment() {

    private val safeArgs: OutputFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOutputBinding.inflate(inflater, container, false)
        with(safeArgs.breedInfo){
            binding.breedOutput.text = breedName
            binding.hairOutput.text = hairLength
        }
        binding.backButton.setOnClickListener { showInput() }
        return binding.root
    }

    private fun showInput() {
        val action = OutputFragmentDirections.actionOutputToInput()
        findNavController().navigate(action)
    }

}