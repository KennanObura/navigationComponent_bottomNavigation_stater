package kennan.co.ke.littlebar.ui.gig

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kennan.co.ke.littlebar.R

class GigThemesFragment : Fragment() {

    companion object {
        fun newInstance() = GigThemesFragment()
    }

    private lateinit var viewModel: GigThemesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gig_themes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GigThemesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
