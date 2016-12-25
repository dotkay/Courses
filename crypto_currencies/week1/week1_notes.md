# Introduction to Crypto and Cryptocurrencies

### Week-1

#### Cryptographic hash functions

A *Cryptographic Hash Function* is a mathematical function with the following properties:
* It takes any string as input (i.e. any string of any size)
* It produces a fixed size output (for our course, we will use 256 bits)
* It is efficienty computable

In particular these functions have several security properties, the key among them being:
* They are collision-free
* They have hiding
* They are puzzle-friendly

Let's quickly take a look at the security properties:

1. Collision-free
    Nobody can find *x* and *y* such that:
    *x != y* and *H(x) = H(y)*

    We only say that "nobody can find" and not that "such x and y don\'t exist". It's just that 
    such computations are too hard.

    No hash function H has been proven Collision free.

    Now, why is this property important? What are it's applications?
    First, if we know that *H(x) = H(y)* then we can safely assume that *x = y*. 
    In order to recognize a file we saw before, we just need to remember it's hash - which is 
    much smaller than the original file. Think about syncing files to the cloud or React, etc.


2. Given *H(x)*, it is impossible to find *x*

    This property again doesn't hold always. If the set that x belongs to is very small, one can
    compute *H(x)* for all elements of the set and match it against the given *H(x)* and find *x*.

    We generally concatenate *x* with *r*.
    
    If *r* is chosen from a probability distribution that has high *min-entropy*, then given *H(r | x)*,
    it is infeasible to find *x*. *High min-entropy* means that the distribution is spread out, so
    that no particular value is chosen with more than a negligible probability. *r | x* means *r* 
    concatenated with *x*.

    Now, why is this property important. The application seems to be something that is referred
    to as **Commitment** - we commit to a value and reveal it later.
    r is the key and x is the message (in usual cryptography terms)

3. For every possible output value *y*, if *k* is chosen from a distribution with high min-entropy,
   it is infeasible to find *x* such that *H(k | x) = y*. 
   