# Graphs

## Vocabulary

Like trees, graphs are formed from *nodes* connected by *edges*.

However, unlike trees, there is no special root node and cycles are allowed.

Sometimes nodes are called *vertices* (plural of *vertex*).

Edges within graphs may be *directed* or *undirected.* Edges may have *weights* associated
with them.

In the figure below, the graph on the left is undirected and unweighted. The
graph on the right is directed and weighted.

![figs/graph.png](figs/graph.png)

**Adjacency List:** One way to represent a graph. Each vertex is associated with
a list of its neighbors.

For example, we could use a hash map, and encode node labels as keys and lists
of neighbors as values. In that case, the graph on the left in the figure would
be represented as


and the directed graph on the right would be

```
0:[1,3]
1:[2]
2:[]
3:[4]
4:[1,2]
```

**Adjacency Matrix:** Another way to represent a graph, this time as a full
matrix. The entry at element $(i,j)$ indicates the presence, absence, or weight
of an edge from node $i$ to node $j$. The undirected unweighted graph could be
written as the following matrix, where 1 indicates the presence of an edge and 0
indicates no edge.

$$
\begin{bmatrix}
0 & 1 & 0 & 1 & 0 \\
1 & 0 & 1 & 0 & 1 \\
0 & 1 & 0 & 0 & 1 \\
1 & 0 & 0 & 0 & 1 \\
0 & 1 & 1 & 1 & 0 \\
\end{bmatrix}
$$

An undirected graph will always produce a symmetric matrix. We may also use
$\infinity$ to represent that node edge is present, usually in weighted graphs
where it may be possible to have an edge with weight zero. In weighted graphs,
the value at element $(i,j)$ of the matrix is the weight of the edge. Using this
convention, the representation of the directed weighted graph would be

$$
\begin{bmatrix}
0 & 3 & \infty & 2 & \infty \\
1 & 0 & 1 & 0 & 1 \\
0 & 1 & 0 & 0 & 1 \\
1 & 0 & 0 & 0 & 1 \\
0 & 1 & 1 & 1 & 0 \\
\end{bmatrix}
$$
