package br.com.washi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


//TODO: Acoplar configuracao Dagger nessa Base Fragment para DI
abstract class BaseFragment : Fragment(), HasAndroidInjector {
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

//    protected inline fun <reified T : ViewModel> viewModels(): Lazy<T> {
//        return viewModels { factory }
//    }
//
//    protected inline fun <reified T : ViewModel> activityViewModels(): Lazy<T> {
//        return this.activityViewModels { factory }
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enableFullScreenFromFragment()
    }

    private fun enableFullScreenFromFragment() {
        activity?.window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}