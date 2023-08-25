package com.taro.minesweeper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taro.minesweeper.databinding.ItemMineSweeperCellBinding

class MineSweeperAdapter(): RecyclerView.Adapter<MineSweeperAdapter.MineSweeperVH>() {

    private var mMineSwpList = listOf<Cell>()

    fun setData(Data: List<Cell>){
        mMineSwpList = Data
    }

    class MineSweeperVH(view: View): RecyclerView.ViewHolder(view){
        var binding = ItemMineSweeperCellBinding.bind(view)

        fun bind(mData: Cell){
            with(binding){
                tvMineCount.text = mData.nearbyMineCount.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MineSweeperVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mine_sweeper_cell, parent, false)
        return MineSweeperVH(view)
    }

    override fun getItemCount(): Int {
        return mMineSwpList.size
    }

    override fun onBindViewHolder(holder: MineSweeperVH, position: Int) {
        holder.bind(mMineSwpList[position])
    }
}