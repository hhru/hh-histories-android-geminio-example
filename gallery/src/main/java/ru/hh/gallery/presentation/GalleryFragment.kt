package ru.hh.gallery.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import ru.hh.gallery.R
import ru.hh.gallery.data.model.GalleryModel
import ru.hh.gallery.data.network.di.GalleryDataModule
import ru.hh.gallery.feature.di.GalleryFeatureModule
import ru.hh.gallery.presentation.adapter.GalleryAdapter
import ru.hh.gallery.presentation.viewmodel.GalleryViewModel
import toothpick.ktp.KTP
import toothpick.ktp.delegate.inject
import toothpick.smoothie.viewmodel.closeOnViewModelCleared
import toothpick.smoothie.viewmodel.installViewModelBinding

class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val viewModel: GalleryViewModel by inject()
    private val adapter = GalleryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KTP.openRootScope()
            .openSubScope(GalleryViewModel::class.java)
            .installViewModelBinding<GalleryViewModel>(this)
            .closeOnViewModelCleared(this)
            .installModules(GalleryFeatureModule(), GalleryDataModule())
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView? = view.findViewById(R.id.fragment_gallery_recycler_view)
        recyclerView?.adapter = adapter

        viewModel.observeUiState(::renderState)
        viewModel.loadData()
    }

    private fun renderState(data: PagingData<GalleryModel>) {
        adapter.submitData(lifecycle, data)
    }
}
