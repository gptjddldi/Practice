package leetcode

    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val lis = mutableListOf<Int>()
        for(i in 1..9) {
            var num = i
            var next = i+1
            while(num <= high && next <=9) {
                num = num * 10 + next
                if(num in low..high) lis+=num
                next++
            }
        }
        return lis.sorted()
    }
