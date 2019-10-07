package br.com.washi.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import br.com.washi.BaseFragment
import br.com.washi.R
import br.com.washi.home.repository.HomeRepository
import br.com.washi.home.viewmodel.HomeViewModel
import br.com.washi.home.viewmodel.HomeViewModelFactory
import br.com.washi.persistence.preferences.Preferences
import br.com.washi.services.MenuMock
import br.com.washi.services.ServiceEnum.*
import br.com.washi.services.ServiceMock
import br.com.washi.util.MarginItemDecoration
import br.com.washi.util.loadImageFromMemory
import br.com.washi.util.setUp
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_service_list.view.*
import kotlinx.android.synthetic.main.card_wash_service.view.*
import kotlinx.android.synthetic.main.content_home.*
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.support.v4.toast
import java.util.*

class HomeFragment : BaseFragment() {
    private val vm: HomeViewModel by lazy {
        ViewModelProviders.of(
            this,
            HomeViewModelFactory(HomeRepository(Preferences))
        ).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.content_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToProfile()
        Picasso.get().loadImageFromMemory("https://picsum.photos/960/960.jpg",
            object : Callback {
                override fun onSuccess() {
                    Picasso.get()
                        .load("https://picsum.photos/960/960.jpg")
                        .into(iv_profile)
                    showProfilePhoto()
                }

                override fun onError(e: Exception?) {
                    toast("Não foi possível carregar a imagem de perfil")
                }
            })
    }

    private fun showProfilePhoto() {
        sf_profile_view.visibility = View.INVISIBLE
        shimmer_profile_container.stopShimmer()
        iv_profile.visibility = View.VISIBLE
    }

    override fun onStart() {
        super.onStart()
        vm.personName.observe(this) {
            showPersonName(it)
        }
    }

    override fun onResume() {
        super.onResume()
        configureView()
    }

    private fun showPersonName(name: String) {
        sf_view.visibility = View.INVISIBLE
        shimmer_name_container.stopShimmer()
        tv_person_name.text = name
        tv_person_name.visibility = View.VISIBLE
    }

    private fun configureView() {
        when (Preferences.getBoolean("IsWorker")) {
            true -> configureListForWorker()
            false -> configureListForRequester()
        }
    }

    private fun navigateToProfile() {
        iv_profile.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeScreenToProfile())
        }
    }

    private fun configureListForRequester() {
        rvList.setUp(
            MenuMock.getSolicitations(),
            R.layout.card_wash_service, {
                service_name.text = it.name
                service_image.imageResource = it.image
            },
            { navigateToAService(name) },
            manager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        )

        rvList.addItemDecoration(
            MarginItemDecoration
                (resources.getDimension(R.dimen.item_spacing).toInt())
        )
    }

    private fun configureListForWorker() {
        rvList.setUp(
            ServiceMock.getServices(),
            R.layout.card_service_list, {
                inicial_service.text = (it.personName.substring(0, 2))
                person_name.text = it.personName
                type_service.text = it.service
                service_price.text = it.totalAmount
                service_quantity.text = it.quantityItens.toString()
            },
            { navigateToAService(service) },
            manager = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
        )
    }

    private fun navigateToAService(name: String) {
        when (name.toUpperCase(Locale.getDefault())) {
            WASH.value -> findNavController().navigate(HomeFragmentDirections.actionHomeScreenToLaundry())
            DRY.value -> toast(name)
            DELIVERY.value -> toast(name)
            ORDERS.value -> findNavController().navigate(HomeFragmentDirections.actionHomeScreenToOrder())
            else -> toast(name)
        }
    }
}
