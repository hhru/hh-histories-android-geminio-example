package ${packageName}.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
<#if applicationPackage??>
import ${applicationPackage}.R
</#if>

<#if useDataModelName == true>
internal class ${adapterName} : PagingDataAdapter<${dataModelName}, ${adapterName}.ViewHolder>(DiffUtilCallback) {
<#else>
internal class ${adapterName} : PagingDataAdapter<Any, ${adapterName}.ViewHolder>(DiffUtilCallback) {
</#if>

    <#if useDataModelName == true>
    companion object {
        private val DiffUtilCallback = object : DiffUtil.ItemCallback<${dataModelName}>() {
            override fun areItemsTheSame(oldItem: ${dataModelName}, newItem: ${dataModelName}): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ${dataModelName}, newItem: ${dataModelName}): Boolean {
                return oldItem == newItem
            }
        }
    }
    <#else>
    companion object {
        private val DiffUtilCallback = object : DiffUtil.ItemCallback<Any>() {
            override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
                return oldItem == newItem
            }
        }
    }
    </#if>

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        if (item != null) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.${viewName}, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }
}
