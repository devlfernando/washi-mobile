package br.com.washi.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.washi.R
import br.com.washi.services.Service
import br.com.washi.util.setUp
import kotlinx.android.synthetic.main.card_wash_service.view.*
import kotlinx.android.synthetic.main.content_home.*

class HomeFragment : Fragment() {

    private val service = listOf(
        Service("Lavar"),
        Service("Passar"),
        Service("Entregar"),
        Service("Outros")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.content_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        rvList.setUp(service, R.layout.card_wash_service, {
            nameProduct.text = it.serviceTitle
        }, manager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false))
    }
}
