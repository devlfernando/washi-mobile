package br.com.washi

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class BaseBottomSheetDialogFragment : BottomSheetDialogFragment() {
    override fun getTheme(): Int {
        return R.style.Theme_MaterialComponents_Light_BottomSheetDialog
    }
}