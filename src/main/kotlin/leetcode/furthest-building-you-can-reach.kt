package leetcode

class Solution {
    var ret = 0
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {

    }

    fun bt(idx: Int, bricks: Int, ladders: Int){
        if(bricks == 0 && ladders == 0){
            ret = maxOf(ret, idx)
            return
        }



    }
}