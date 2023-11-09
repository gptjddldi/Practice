package datastructure.Graph

class AdjacencyList<T>: Graph<T> {
    val lis: HashMap<Vertex<T>, ArrayList<Edge<T>>> = HashMap()
    override fun createVertex(data: T): Vertex<T> {
        val vtx = Vertex(lis.size, data)
        lis[vtx] = ArrayList()
        return vtx
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        lis[source]?.add(edge)
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
        return lis[source] ?: arrayListOf()
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return edges(source).firstOrNull { it.source == source && it.destination == destination }?.weight
    }

    override fun toString(): String {
        return buildString {
            lis.forEach{ (vertex, edges) ->
                val edgeString = edges.joinToString { it.destination.toString() }
                append("${vertex.data} ---->[$edgeString]\n")
            }
        }
    }
}

