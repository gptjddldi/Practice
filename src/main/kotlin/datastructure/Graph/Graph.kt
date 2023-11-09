package datastructure.Graph

data class Vertex<T>(val index: Int, val data: T){
    override fun toString(): String {
        return "$data"
    }
}
data class Edge<T> (
    val source: Vertex<T>,
    val destination: Vertex<T>,
    val weight: Double? = null
)
interface Graph<T> {
    fun createVertex(data: T): Vertex<T>
    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)
    fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)
    fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?)
    fun edges(source: Vertex<T>): ArrayList<Edge<T>>
    fun weight(source: Vertex<T>, destination: Vertex<T>): Double?
}

enum class EdgeType {
    DIRECTED,
    UNDIRECTED
}