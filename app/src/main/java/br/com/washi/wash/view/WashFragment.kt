package br.com.washi.wash.view


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.washi.BaseFragment
import kotlinx.android.synthetic.main.content_wash_bottomsheet.*
import kotlinx.android.synthetic.main.custom_notification_layout.*
import kotlin.random.Random


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

        circular_buttom_wash.setOnClickListener {
            notification_badge.text = notification_badge.text
                .toString()
                .toInt()
                .plus(1)
                .toString()

            tv_cash_value.text = "R$ ${Random.nextInt(10, 180)}"
        }

        et_quantity_clothes.requestFocus()
        appendBags()
    }

    private fun appendBags() {
        et_quantity_clothes.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                tv_label_title_bags.visibility = View.VISIBLE
                tv_label_title_bags.text = if (text.toString().isEmpty().not()
                    && text.toString().toInt() > 1
                ) "bags" else "bag"
            }
        })
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
