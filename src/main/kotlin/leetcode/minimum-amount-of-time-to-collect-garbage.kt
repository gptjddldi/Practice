package leetcode

fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
    var g = 0
    var p = 0
    var m = 0
    var ret = 0
    for (i in garbage.indices){
        ret += garbage[i].length
        if(garbage[i].contains("G")) g = i
        if(garbage[i].contains("P")) p = i
        if(garbage[i].contains("M")) m = i
    }
    for (i in travel.indices){
        if(g > i) ret += travel[i]
        if(p > i) ret += travel[i]
        if(m > i) ret += travel[i]
    }

    return ret
}
