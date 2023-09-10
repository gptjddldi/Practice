package `Stack and Queue`

class RingBuffer<T>(private val capacity: Int) {
    private val lis = ArrayList<T>(capacity)
    private var readIdx = 0
    private var writeIdx = 0

    private val availableSpaceForReading: Int
        get() = (writeIdx - readIdx)

    private val availableSpaceForWriting: Int
        get() = (capacity - availableSpaceForReading)
    fun write(element: T): Boolean {
        return if(!isFull){
            if(writeIdx <  capacity){
                lis.add(writeIdx++, element)
            } else lis[writeIdx ++ % capacity] = element
            true
        } else false
    }

    fun read(): T? {
        return if(!isEmpty){
            lis.get(readIdx ++ % capacity)
        } else null
    }
    val count: Int
        get() = availableSpaceForReading

    val isEmpty: Boolean
        get() = count == 0

    val isFull: Boolean
        get() = availableSpaceForWriting == 0
}