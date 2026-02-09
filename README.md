# Assignment 1
This Java program generates random numbers using three different Java random number generators and performs descriptive statistical analysis on all three generators.

- **Full Name:** Huseyn Mirzayev
- **Project Name:** Random Numbers Generation and their Statistical Analysis
- **Class:** Object Oriented Analysis & Design (CRN - 20966)
- **Date:** 9 February

## What it does
- Generates random numbers using three methods:
  1. `java.util.Random`
  2. `Math.random()`
  3. `java.util.concurrent.ThreadLocalRandom`
- Analyzes data with descriptive statistics (n, mean, std dev, min, max)
- Tests three sample sizes: 12, 254, and 10000 (figures randomly chosen by me)
- Produces 9 total results (3 generators, each by 3 sample sizes)



## Code Structure

### Class and Methods
The `Generator` class contains the following methods:

1. **`populate(int n, int randNumGen)`**
   - Generates n random double values in [0, 1)
   - Parameters:
     - `n`: number of values to generate
     - `randNumGen`: generator type (1=Random, 2=Math.random, 3=ThreadLocalRandom)
   - Returns: ArrayList of random values

2. **`statistics(ArrayList<Double> randomValues)`**
   - Calculates mean, min, max and standard deviation
   - Returns: ArrayList containing [n, mean, stddev, min, max]

3. **`display(ArrayList<Double> results, boolean headerOn)`**
   - Displays results in tabular format
   - Parameters:
     - `results`: statistical values to display
     - `headerOn`: whether to show column headers

4. **`execute()`**
   - Main execution method
   - Runs all combinations of sample sizes and generators
   - Produces organized output with headers for each generator

## Expected Output

The program will display results for each of the three random number generators, with statistics for sample sizes of 12, 254, and 10000.

### Sample Output Format:
```
Random Number Generator Statistical Analysis
=====================================================


Generator: java.util.Random
========================================================================
n               Mean            Std Dev         Min             Max            
========================================================================
12              0.539965        0.272662        0.075058        0.903119       
254             0.526613        0.284312        0.009613        0.991011       
10000           0.498235        0.286870        0.000018        0.999967       

Generator: Math.random()
========================================================================
n               Mean            Std Dev         Min             Max            
========================================================================
12              0.418906        0.259996        0.069550        0.840103       
254             0.497869        0.300062        0.000171        0.997975       
10000           0.507252        0.290346        0.000003        0.999970       

Generator: java.util.concurrent.ThreadLocalRandom
========================================================================
n               Mean            Std Dev         Min             Max            
========================================================================
12              0.594414        0.274325        0.047204        0.935473       
254             0.522794        0.279095        0.002293        0.991251       
10000           0.501153        0.287550        0.000345        0.999748       

========================================================================
Analysis complete. Total results: 9
========================================================================
```

## Statistical Expectations

As described in the requirements, when sample size increases:
- **Mean** approaches 0.5
- **Standard Deviation** approaches approximately 0.29 
- **Minimum** approaches 0
- **Maximum** approaches 1

Small samples (n=12) will show more deviation from theoretical values.



