package leetcode

class RandomizedSet() {
    private val mp = hashMapOf<Int, Boolean>()

    fun insert(`val`: Int): Boolean {
        if(mp[`val`] == true) return false
        mp[`val`] = true
        return true
    }

    fun remove(`val`: Int): Boolean {
        if(mp[`val`] != true) return false
        mp.remove(`val`)
        return true
    }

    fun getRandom(): Int {
        return mp.keys.random()
    }
}
