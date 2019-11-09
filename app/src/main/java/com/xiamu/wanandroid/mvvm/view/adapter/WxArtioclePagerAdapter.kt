package com.xiamu.wanandroid.mvvm.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.xiamu.wanandroid.mvvm.model.entry.TreeBean
import com.xiamu.wanandroid.mvvm.view.fragment.KnowledgeFragment
import com.xiamu.wanandroid.mvvm.view.fragment.WxArticleDetailFragment

/**
 * Created by zhengxiaobo in 2019-11-09
 */
class WxArtioclePagerAdapter(val list: List<TreeBean>, fm: FragmentManager): FragmentStatePagerAdapter(fm){
    private val fragments = mutableListOf<Fragment>()

    init {
        fragments.clear()
        list.forEach {
            fragments.add(WxArticleDetailFragment.getInstance(it.id))
        }
    }

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = list.size

    override fun getPageTitle(position: Int): CharSequence? = list[position].name

    override fun getItemPosition(`object`: Any): Int = PagerAdapter.POSITION_NONE


}