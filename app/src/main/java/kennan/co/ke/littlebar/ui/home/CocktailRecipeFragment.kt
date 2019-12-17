package kennan.co.ke.littlebar.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kennan.co.ke.littlebar.R

class CocktailRecipeFragment : Fragment() {

    companion object {
        fun newInstance() = CocktailRecipeFragment()
    }

    private lateinit var viewModel: CockItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cock_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CockItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
