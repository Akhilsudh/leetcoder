# leetcoder
[![leetcode](https://img.shields.io/badge/-akhil__sudh-F89F1B?style=for-the-badge&logo=leetcode&logoColor=white)](https://leetcode.com/akhil_sudh/)

My scratchbook for coding problems

## Some points taken
* Largest common prefix problem thoughts
  * Approach by sorting: Sorting the array of strings and using the first and the last (most dissimilar) strings only to figure out the largest common prefix.
  * Approach by using a Trie: Save all the strings into a Trie data structure and find the lone nodes from root till the first node that has more nodes in it and return the constructed prefix string.
