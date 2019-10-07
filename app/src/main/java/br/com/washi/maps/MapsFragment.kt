package br.com.washi.maps


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.washi.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_maps.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.support.v4.toast


class MapsFragment : Fragment(), OnMapReadyCallback {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_maps, container, false)
        val spMapsFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        spMapsFragment?.getMapAsync(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab_next_payment.setOnClickListener {
            toast("Pagamento realizado, aguarde um momento...")
            CoroutineScope(Dispatchers.Main).launch {
                delay(4000)
                findNavController().navigate(MapsFragmentDirections.actionMapsFragmentToOrderFragment())
            }
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    override fun onMapReady(googleMap: GoogleMap?) {
        // Add a marker in Sydney and move the camera
        val sp = LatLng(-23.5505, -46.6333)
        googleMap?.addMarker(MarkerOptions().position(sp).title("Marcador em SP"))
        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(sp))
    }

    private fun triggerPayment() {
        toast("Pagamento realizado, aguarde...")

    }
}
