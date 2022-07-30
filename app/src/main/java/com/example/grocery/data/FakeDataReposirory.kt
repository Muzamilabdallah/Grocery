package com.example.grocery.data

import com.example.grocery.R
import com.example.grocery.domain.model.Category
import com.example.grocery.domain.model.Product

object FakeDataReposirory {
    var banner = mutableListOf<Int>()

    @JvmName("getBanner1")
    fun getBanner(): List<Int> {
        return banner.apply {
            add(R.drawable.banner)
            add(R.drawable.banner)
            add(R.drawable.banner)
        }
    }

    fun getCategories(): List<Category> {
        return mutableListOf(
            Category("Fruit", R.drawable.fruit),
            Category("vegetables", R.drawable.broccoli),
            Category("Diary", R.drawable.diary),
            Category("Meat", R.drawable.meat)
        )
    }

    fun getBestSellingItems():List<Product>{
        return  mutableListOf(
            Product("Bell Pepper Red",R.drawable.pepper_red,"1kg",4),
            Product("Organic Carrot",R.drawable.carrot,"1kg",2),
                    Product("Arabic Ginger",R.drawable.brocollbigg,"1kg",2)
        )
    }


    fun  getProductsByCategory():List<Product>{
        return  mutableListOf(
            Product("Bell Pepper Red",R.drawable.pepper_red,"1kg",4),
            Product("Arabic Ginger",R.drawable.ginger,"1kg",4),
            Product("Fresh Lettuce",R.drawable.lettuce,"1kg",2),
            Product("Butternut Squash",R.drawable.squash,"1kg",8),
            Product("Organic Carrot",R.drawable.carrot,"1kg",2),
            Product("Fresh Broccoli",R.drawable.brocollbigg,"1kg",2),
            Product("Butternut Squash",R.drawable.squash,"1kg",8),
            Product("Organic Carrot",R.drawable.carrot,"1kg",2),
            Product("Butternut Squash",R.drawable.squash,"1kg",8),
            Product("Organic Carrot",R.drawable.carrot,"1kg",2),
            Product("Fresh Lettuce",R.drawable.lettuce,"1kg",2),
            Product("Butternut Squash",R.drawable.squash,"1kg",8),
            Product("Bell Pepper Red",R.drawable.pepper_red,"1kg",4),
            Product("Arabic Ginger",R.drawable.ginger,"1kg",4),
        )
    }



}
