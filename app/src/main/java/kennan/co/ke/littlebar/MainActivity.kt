package kennan.co.ke.littlebar

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kennan.co.ke.littlebar.ui.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(),
    ViewPager.OnPageChangeListener,
    BottomNavigationView.OnNavigationItemReselectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    private val rootFragments = listOf(
        BaseFragment.newInstance(
            R.layout.content_home_base,
            R.id.toolbar_home,
            R.id.nav_host_home
        ),
        BaseFragment.newInstance(
            R.layout.content_gig_base,
            R.id.toolbar_gig,
            R.id.nav_host_gig
        ),
        BaseFragment.newInstance(
            R.layout.content_search_base,
            R.id.toolbar_search,
            R.id.nav_host_search
        ),
        BaseFragment.newInstance(
            R.layout.content_shopping_base,
            R.id.toolbar_shopping,
            R.id.nav_host_shopping
        ),
        BaseFragment.newInstance(
            R.layout.content_profile_base,
            R.id.toolbar_profile,
            R.id.nav_host_profile
        )
    )


    // overall back stack of containers
    private val backStack = Stack<Int>()

    // map of navigation_id to container index
    private val indexToPage =
        mapOf(0 to R.id.home, 1 to R.id.gig, 2 to R.id.search, 3 to R.id.shopping_list, 4 to R.id.profile)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setup main view pager
        main_pager.addOnPageChangeListener(this)
        main_pager.adapter = ViewPagerAdapter()
        main_pager.post(this::checkDeepLink)
        main_pager.offscreenPageLimit = rootFragments.size

        // set bottom nav
        bottom_nav.setOnNavigationItemSelectedListener(this)
        bottom_nav.setOnNavigationItemReselectedListener(this)

        // initialize backStack with elements
        if (backStack.empty()) backStack.push(0)
    }


    // control the backStack when back button is pressed
    override fun onBackPressed() {

        // get the current page
        val currentFragment = rootFragments[main_pager.currentItem]

        // check if the page navigates up
        val navigatedUp = currentFragment.onBackPressed()

        // if no fragments were popped
        if (!navigatedUp) {
            if (backStack.size > 1) {
                // remove current position from stack
                backStack.pop()
                // set the next item in stack as current
                main_pager.currentItem = backStack.peek()

            } else super.onBackPressed()
        }
    }

    private fun checkDeepLink() {
        rootFragments.forEachIndexed { index, fragment ->
            val hasDeepLink = fragment.handleDeepLink(intent)
            if (hasDeepLink) setItem(index)
        }
    }


    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        val itemId = indexToPage[position] ?: R.id.home
        if (bottom_nav.selectedItemId != itemId)
            bottom_nav.selectedItemId = itemId
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        val position = indexToPage.values.indexOf(item.itemId)
        val fragment = rootFragments[position]
        fragment.popToRoot()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val position = indexToPage.values.indexOf(item.itemId)
        if (main_pager.currentItem != position) setItem(position)
        return true
    }

    private fun setItem(position: Int) {
        main_pager.currentItem = position
        backStack.push(position)
    }


    inner class ViewPagerAdapter : FragmentPagerAdapter(supportFragmentManager) {
        override fun getItem(position: Int): Fragment = rootFragments[position]

        override fun getCount(): Int = rootFragments.size

    }

}
