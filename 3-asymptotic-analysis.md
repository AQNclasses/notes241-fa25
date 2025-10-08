# Asymptotic Analysis

Much of computer science theory is concerned with the following question:

What resources are required to run an algorithm, and how does resource usage
scale with increasing size of the algorithm input?

Resources:

- time
- space
- energy
- threads
- crabs

(video: a crab computer the size of the world)

Resources are defined by your *computational model*.

We'll make several simplifying assumptions:

- Single thread (single-head Turing machine)
- Unit operations (addition, subtraction, multiplication, division, etc) take
*constant time*: do not depend on size of numbers involved

Using your computational model, we can count the number of unit steps necessary
to complete an algorithm. We can write a function that describes how this number
of steps grows, as a function of the size of the algorithm input.

Each function will be different; but we can sort them into classes based on
their limiting behavior as *n* grows very large. We use "big O" notation as a
shorthand to say, this function belongs to a certain class of functions.
Specifically, the big O function is a **lower bound** on the resources required.

Example: $T(n) = 5n + 10n**2 = O(n**2)$

Example: $T(n) = 100000 + n = O(n)$

Example: $T(n) = 10n + 5\log(n) = O(\log(n))$

The general idea is we drop all constant and coefficients, then drop
"lower-order" terms.

Example: search in an array of size N

Input: *Sorted* array of N integers

Goal: Yes/no decision of whether integer X is present in the array

How to search?

1. Linear search: start at index 0, increment until you find X or a larger
integer

Best case: immediate return

Worst case: O(N)

2. Binary Search: start at index N/2, recurse on half of the array that may
contain X

Best case: immediate return

Worst case: Observe that the array size decreases by roughly 1/2 at each
recursion. The algorithm will return when one element is left.

After $k$ operations, we will have $N/2^k$ elements remaining to search.

We terminate when $N/2^k \leq 1$. Solve for $k$, get $O(\log(k))$.
