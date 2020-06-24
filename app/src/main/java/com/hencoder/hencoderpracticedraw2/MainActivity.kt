package com.hencoder.hencoderpracticedraw2

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import java.util.*

class MainActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var pager: ViewPager? = null
    var pageModels: MutableList<PageModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager = findViewById(R.id.pager) as ViewPager
        pager!!.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                val pageModel = pageModels[position]
                return PageFragment.Companion.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes)
            }

            override fun getCount(): Int {
                return pageModels.size
            }

            override fun getPageTitle(position: Int): CharSequence {
                return getString(pageModels[position].titleRes)
            }
        }
        tabLayout = findViewById(R.id.tabLayout) as TabLayout
        tabLayout!!.setupWithViewPager(pager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    inner class PageModel internal constructor(@field:LayoutRes @param:LayoutRes var sampleLayoutRes: Int, @field:StringRes @param:StringRes var titleRes: Int, @field:LayoutRes @param:LayoutRes var practiceLayoutRes: Int)

    init {
        pageModels.add(PageModel(R.layout.sample_linear_gradient, R.string.title_linear_gradient, R.layout.practice_linear_gradient))
        pageModels.add(PageModel(R.layout.sample_radial_gradient, R.string.title_radial_gradient, R.layout.practice_radial_gradient))
        pageModels.add(PageModel(R.layout.sample_sweep_gradient, R.string.title_sweep_gradient, R.layout.practice_sweep_gradient))
        pageModels.add(PageModel(R.layout.sample_bitmap_shader, R.string.title_bitmap_shader, R.layout.practice_bitmap_shader))
        pageModels.add(PageModel(R.layout.sample_compose_shader, R.string.title_compose_shader, R.layout.practice_compose_shader))
        pageModels.add(PageModel(R.layout.sample_lighting_color_filter, R.string.title_lighting_color_filter, R.layout.practice_lighting_color_filter))
        pageModels.add(PageModel(R.layout.sample_color_mask_color_filter, R.string.title_color_matrix_color_filter, R.layout.practice_color_matrix_color_filter))
        pageModels.add(PageModel(R.layout.sample_xfermode, R.string.title_xfermode, R.layout.practice_xfermode))
        pageModels.add(PageModel(R.layout.sample_stroke_cap, R.string.title_stroke_cap, R.layout.practice_stroke_cap))
        pageModels.add(PageModel(R.layout.sample_stroke_join, R.string.title_stroke_join, R.layout.practice_stroke_join))
        pageModels.add(PageModel(R.layout.sample_stroke_miter, R.string.title_stroke_miter, R.layout.practice_stroke_miter))
        pageModels.add(PageModel(R.layout.sample_path_effect, R.string.title_path_effect, R.layout.practice_path_effect))
        pageModels.add(PageModel(R.layout.sample_shadow_layer, R.string.title_shader_layer, R.layout.practice_shadow_layer))
        pageModels.add(PageModel(R.layout.sample_mask_filter, R.string.title_mask_filter, R.layout.practice_mask_filter))
        pageModels.add(PageModel(R.layout.sample_fill_path, R.string.title_fill_path, R.layout.practice_fill_path))
        pageModels.add(PageModel(R.layout.sample_text_path, R.string.title_text_path, R.layout.practice_text_path))
    }
}