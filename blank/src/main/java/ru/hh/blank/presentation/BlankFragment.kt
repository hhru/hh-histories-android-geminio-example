package ru.hh.blank.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import ru.hh.blank.R
import ru.hh.blank.data.model.BlankData
import ru.hh.blank.data.network.di.BlankRemoteModule
import ru.hh.blank.feature.di.BlankFeatureModule
import ru.hh.blank.presentation.adapter.BlankAdapter
import ru.hh.blank.presentation.viewmodel.BlankViewModel
import toothpick.ktp.KTP
import toothpick.ktp.delegate.inject
import toothpick.smoothie.viewmodel.closeOnViewModelCleared
import toothpick.smoothie.viewmodel.installViewModelBinding

class BlankFragment : Fragment(R.layout.fragment_blank) {

    private val viewModel: BlankViewModel by inject()
    private val adapter = BlankAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KTP.openRootScope()
            .openSubScope(BlankViewModel::class.java)
            .installViewModelBinding<BlankViewModel>(this)
            .closeOnViewModelCleared(this)
            .installModules(BlankFeatureModule(), BlankRemoteModule())
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView? = view.findViewById(R.id.fragment_blank_recycler_view)
        recyclerView?.adapter = adapter

        viewModel.observeUiState(::renderState)
        viewModel.loadData()
    }

    private fun renderState(data: PagingData<BlankData>) {
        adapter.submitData(lifecycle, data)
    }
}
