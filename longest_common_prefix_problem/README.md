# Longest Common Prefix Problem

Here are two approaches to solving this problem

- Approach by sorting: Sorting the array of strings and using the first and the last strings to figure out the largest common prefix.

  Through sorting we see that the first and the last string are the most dissimilar strings, hence the longes prefix between these two strings must be the longest prefix for all the strings in the provided list

- Approach by using a Trie: Save all the strings into a custom "[Trie data structure](https://en.wikipedia.org/wiki/Trie)". A trie data structure also known as a prefix tree is a kind of search tree—an ordered tree data structure used to store a dynamic set or associative array where the keys are usually strings. In the Trie structure below we do not see any common prefix occuring in the root node, but on the left hand portion of the trie we see that the largest common prefix is the letter 't'.

![Source](https://upload.wikimedia.org/wikipedia/commons/b/be/Trie_example.svg)

  In our implementation to find the largest common prefix we need to find all the nodes from root till the first time a node branches into more nodes and return the constructed prefix string.
