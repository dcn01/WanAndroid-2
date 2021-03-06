package com.xiamu.wanandroid.mvvm.view.adapter

import com.xiamu.baselibs.mvvm.binding.BaseBindAdapter
import com.xiamu.baselibs.mvvm.binding.BaseBindHolder
import com.xiamu.wanandroid.BR
import com.xiamu.wanandroid.R
import com.xiamu.wanandroid.mvvm.model.entry.TreeItemData

/**
 * Created by zhengxiaobo in 2019-11-09
 */
class ProjectAdapter (data: List<TreeItemData>?): BaseBindAdapter<TreeItemData>(R.layout.item_project_layout, data){

    override fun convert(helper: BaseBindHolder?, item: TreeItemData?) {
        val binding = helper?.getBinding()
        binding?.setVariable(BR.projectItemData, item)

        //它使数据绑定刷新所有挂起的更改。否则，它将视为另一个布局失效了
        binding?.executePendingBindings()
    }
}
