package kennan.co.ke.littlebar.ui.gig

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kennan.co.ke.littlebar.R

class GigItemsFragment : Fragment() {

    companion object {
        fun newInstance() = GigItemsFragment()
    }

    private lateinit var viewModel: GigItemsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gig_items_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GigItemsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
