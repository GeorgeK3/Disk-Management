# Disk Management

**Disk Management** is a disk allocation project created as part of a Data Structures course. The project simulates the allocation of folders (with various sizes) onto disks using two primary strategies:
- A **greedy algorithm** based on a priority queue (MaxPQ) with custom comparators (`DiskComparator` and `FolderComparator`).
- An **optimized variant** that first sorts the folders in descending order using a generic quicksort implementation before applying the greedy strategy.

The simulation measures the efficiency of both approaches by comparing the average number of disks required for different test cases.

## Overview

The project is divided into four main parts:

### Part A
- **Priority Queue Implementation:**  
  Implements a MaxPQ using generics, along with custom comparators:
  - **DiskComparator:** Defines how disks are ordered.
  - **FolderComparator:** Helps the priority queue manage the folders that each disk can contain.
- The `Disk` class implements `Comparable<Disk>`, fulfilling the assignment requirements even though the internal sorting relies on a custom `Comparator`.

### Part B
- **File Input and Greedy Algorithm:**  
  The program uses the `java.nio.file` package to count lines in a text file to determine the number of folders, and then reads the folder sizes into an array.
  - It creates the first `Disk` and adds the first folder.
  - For each subsequent folder, the algorithm uses `peek()` on the priority queue to check if the folder fits into the disk with the most available space.
  - If it doesn't fit, a new disk is created and added to the queue.
  - If it does fit, the disk is updated by removing it (with `getMax()`), adding the folder, and then re-inserting it into the queue to maintain the proper order.
- Two counters track the total number of disks created and the cumulative folder sizes.

### Part C
- **Sorting with Quicksort:**  
  Implements a generic quicksort (in `Sort.java`) to arrange the folders by size in descending order.  
  - Uses the last element as the pivot and recursively sorts the partitions.
  - This sorting is used to pre-arrange folder sizes before applying the greedy algorithm, aiming to reduce the number of disks needed.

### Part D
- **Random Test File Generation and Simulation:**  
  Contains two classes:
  - **Comparison.java:**  
    Generates random files with folder sizes (ranging from 0 to 1,000,000) for various predefined numbers of folders (e.g., N = 100, 500, 1000). These files are stored in corresponding subdirectories (e.g., `N100`, `N500`, `N1000`).
  - **Greedy_2.java:**  
    Runs simulations on the generated files by applying both the original greedy algorithm and the sorted (optimized) variant.  
    The program calculates the average number of disks required by each algorithm. Preliminary results indicate that the optimized algorithm uses approximately 14% fewer disks on average, with the difference becoming more significant as the number of folders increases.

---

## Features

- **Generics-Based Data Structures:**  
  Utilizes generics in the implementation of a MaxPQ and in the quicksort algorithm.
  
- **Custom Comparators:**  
  Implements `DiskComparator` and `FolderComparator` for proper ordering within the priority queue.

- **Greedy Allocation Algorithm:**  
  Efficiently allocates folders to disks by always choosing the disk with the most available space.

- **Optimized Sorting:**  
  Incorporates a generic quicksort to pre-sort folder sizes, further optimizing disk allocation.

- **Randomized Testing:**  
  Supports generating random test cases to simulate real-world scenarios and compare the efficiency of different strategies.
