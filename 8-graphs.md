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

For example, we could use a hash map, and encode
