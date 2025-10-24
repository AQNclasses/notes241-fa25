# Tree Definitions

# Binary tree traversal

- **pre-order**:
  1. process current node
  2. recursively traverse Left subtree
  3. recursively traverse Right subtree
  - Pre-order returns nodes in *topologically sorted* order: for every directed
  edge from *u* to *v*, we will return *u* before *v*
  - Another way of saying, pre-order traversals always visit *roots* before
  *leaves*
  - Also will return nodes in order needed to make a copy of tree!
- **in-order**:
  1. recursively traverse Left subtree
  2. process current node
  3. recursively traverse Right subtree
  - gives nodes in order for a binary search tree (will discuss next week)
- **post-order**:
    1. recursively traverse Left subtree
    2. recursively traverse Right subtree
    3. process current node
    - Useful for binary *expression* trees: can handle binary and unary operators
    - Example: A + B * C
    - "Reverse Polish Notation" and history of calculators
    - Explore *leaves* before *nodes*
      - Example: tree is computing partial cumulative sums of leaves, or average scores of different populations
