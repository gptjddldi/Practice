package datastructure.Graph

class AdjacencyMatrix<T>: Graph<T> {
    val vertices= ArrayList<Vertex<T>>()
    val matrix= ArrayList<ArrayList<Double?>>()
    override fun createVertex(data: T): Vertex<T> {
        val vtx = Vertex(vertices.size, data)
        vertices.add(vtx)
        matrix.forEach{
            it.add(null)
        }
        matrix.add(arrayListOf())
        return vtx
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        matrix[source.index][destination.index] = weight
    }

    override fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        when (edge){
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        TODO("Not yet implemented")
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        TODO("Not yet implemented")
    }
}