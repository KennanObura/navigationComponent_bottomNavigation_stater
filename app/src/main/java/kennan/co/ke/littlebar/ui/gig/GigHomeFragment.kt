package kennan.co.ke.littlebar.ui.gig

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kennan.co.ke.littlebar.R

class GigHomeFragment : Fragment() {

    companion object {
        fun newInstance() = GigHomeFragment()
    }

    private lateinit var viewModel: GigHomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gig_home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GigHomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
