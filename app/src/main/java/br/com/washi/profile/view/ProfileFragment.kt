package br.com.washi.profile.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import br.com.washi.R
import br.com.washi.persistence.preferences.Preferences
import br.com.washi.profile.repository.ProfileRepository
import br.com.washi.profile.viewmodel.ProfileViewModel
import br.com.washi.profile.viewmodel.ProfileViewModelFactory
import br.com.washi.util.loadImageFromMemory
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_profile.*
import org.jetbrains.anko.support.v4.toast

class ProfileFragment : Fragment() {
    private val vm: ProfileViewModel by lazy {
        ViewModelProviders.of(
            this,
            ProfileViewModelFactory(ProfileRepository(Preferences))
        ).get(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get().loadImageFromMemory("https://picsum.photos/960/960.jpg",
            object : Callback {
                override fun onSuccess() {
                    Picasso.get()
                        .load("https://picsum.photos/960/960.jpg")
                        .into(iv_profile_detail)
                }

                override fun onError(e: Exception?) {
                    toast("Não foi possivel carregar sua foto de perfil")
                }

            })

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

        vm.name.observe(this) {
            tv_profile_name.text = it
        }
    }

    override fun onResume() {
        super.onResume()
        sc_btn.isChecked = Preferences.getBoolean("IsWorker")
    }
}
