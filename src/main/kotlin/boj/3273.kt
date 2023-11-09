package boj// 3273

fun main(){
    val br = java.io.BufferedReader(java.io.InputStreamReader(System.`in`))
    val num = br.readLine().toInt()
    val nums = br.readLine()
    val tar = br.readLine().toInt()

    val arr = IntArray(2000003)
    var ret = 0
    val arr1 = nums.split(" ").map{it.toInt()}
    arr1.forEach {
        if(arr[it] > 0){
            ret ++
        }
        else if(tar - it > 0) {
            arr[tar - it]++
        }
    }
    print(ret)
}


//fun boj.boj.boj.boj.boj.main(){
//    val br = java.io.BufferedReader(java.io.InputStreamReader(System.`in`))
//    br.readLine().toInt()
//    val nums = br.readLine().split(" ").map{it.toInt()}
//    val tar = br.readLine().toInt()
//
//    val d = mutableMapOf<Int, Boolean>()
//    var boj.getRet = 0
//
//    nums.forEach {
//        if(d[tar - it] == true){
//            boj.getRet ++
//        }
//        else {
//            d[it] = true
//        }
//    }
//    print(boj.getRet)
//}