package ${packageName}

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
<#if applicationPackage??>import ${applicationPackage}.R</#if>
<#if useMviViewModel == true>
import ${packageName}.viewmodel.${viewModelName}
</#if>
import toothpick.ktp.KTP
import toothpick.ktp.delegate.inject
<#if useMviViewModel == true>
import toothpick.smoothie.viewmodel.closeOnViewModelCleared
import toothpick.smoothie.viewmodel.installViewModelBinding
</#if>

class ${fragmentName} : Fragment(R.layout.${fragmentLayoutResName}) {

<#if useMviViewModel == true>
    private val viewModel: ${viewModelName} by inject()
</#if>
    private val adapter = TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    <#if useMviViewModel == true>
        KTP.openRootScope()
            .openSubScope(${viewModelName}::class.java)
            .installViewModelBinding<${viewModelName}>(this)
            .closeOnViewModelCleared(this)
            .installModules(TODO())
            .inject(this)
    </#if>
    <#if useMviViewModel == false>
        KTP.openRootScope()
            .openSubScope(this::class.java)
            .installModules(TODO())
            .inject(this)
    </#if>
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView? = view.findViewById(R.id.${fragmentLayoutResName}_recycler_view)
        recyclerView?.adapter = adapter

    <#if useMviViewModel == true>
        viewModel.observeUiState(::renderState)
        viewModel.loadData()
     </#if>
    }

    private fun renderState(data: Any) {
        adapter.submitData(lifecycle, data)
    }
}
