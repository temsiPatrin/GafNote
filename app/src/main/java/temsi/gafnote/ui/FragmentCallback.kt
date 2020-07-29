package temsi.gafnote.ui

import android.os.Bundle

interface FragmentCallback {
    fun loadMainFragment()
    fun loadCreateFragment()
    fun onItemClick(args: Bundle)
    fun loadEditFragmentWithNote(args: Bundle)
}