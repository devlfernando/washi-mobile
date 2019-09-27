package br.com.washi.wash.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.washi.BaseFragment
import kotlinx.android.synthetic.main.content_wash_bottomsheet.*
import kotlinx.android.synthetic.main.custom_notification_layout.*


class WashFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(br.com.washi.R.layout.fragment_wash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backToHome()
        goToCart()
    }

    private fun backToHome() {
        iv_back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun goToCart() {
        iv_basket_clothes.setOnClickListener {
            findNavController().navigate(WashFragmentDirections.actionWashFragmentToCartFragment())
        }
    }
}
