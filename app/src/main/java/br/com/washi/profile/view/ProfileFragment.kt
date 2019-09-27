package br.com.washi.profile.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.washi.R
import br.com.washi.persistence.preferences.Preferences
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv_back_profile.setOnClickListener {
            findNavController().popBackStack()
        }

        sc_btn.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                true -> {
                    tv_label_worker.text = getText(R.string.label_switch_button_disabled)
                    Preferences.setBoolean("IsWorker", isChecked)
                }
                false -> {
                    tv_label_worker.text = getText(R.string.label_switch_button_enable)
                    Preferences.setBoolean("IsWorker", isChecked)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        sc_btn.isChecked = Preferences.getBoolean("IsWorker")
    }
}
