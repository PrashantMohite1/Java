
# Time Complexity

Time complexity is a way to measure how the time it takes for a computer to run a program or algorithm changes as the size of the input data increases. It helps us understand how well an algorithm performs as the amount of data it processes grows.

1. **Constant Time (O(1))**
   - **What it means:** The time it takes to run the algorithm does not change with the size of the input.
   - **Example:** Suppose you have a list of numbers and you want to get the first number. It doesn’t matter how many numbers are in the list; retrieving the first number always takes the same amount of time.

2. **Linear Time (O(n))**
   - **What it means:** The time it takes to run the algorithm grows linearly with the size of the input.
   - **Example:** Imagine you have a list of numbers and you want to find a specific number. You have to look at each number one by one. If you have 10 numbers, you might need to look at all 10; if you have 100 numbers, you might need to look at all 100. The time increases directly with the number of numbers.

3. **Quadratic Time (O(n^2))**
   - **What it means:** The time it takes to run the algorithm grows proportionally to the square of the size of the input.
   - **Example:** Suppose you have a list of numbers and you want to compare each number with every other number to find duplicates. For 10 numbers, you might have to make 100 comparisons; for 100 numbers, you might have to make 10,000 comparisons. The time grows very quickly as the input size increases.

4. **Logarithmic Time (O(log n))**
   - **What it means:** The time it takes to run the algorithm grows logarithmically with the size of the input. This is much slower growth compared to linear or quadratic.
   - **Example:** Consider a binary search algorithm that looks for a number in a sorted list. With each step, it halves the number of items to check. For 100 numbers, you might need about 7 steps (since 2^7 = 128); for 1,000 numbers, you might need about 10 steps (since 2^10 = 1,024). The time increases much slower compared to linear or quadratic.

### Summary
- **O(1)**: Constant time – time doesn’t change with input size.
- **O(n)**: Linear time – time grows directly with input size.
- **O(n^2)**: Quadratic time – time grows with the square of the input size.
- **O(log n)**: Logarithmic time – time grows logarithmically with the input size.

