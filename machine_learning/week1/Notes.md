# ML - Week-1 - Notes
#### Machine Learning definitions:

Tom Mitchell provides a more modern definition: "A computer program is said to learn from experience E with respect to some class of tasks T and performance measure P, if its performance at tasks in T, as measured by P, improves with experience E."
Example: playing checkers
E = the experience of playing many games of checkers
T = the task of playing checkers.
P = the probability that the program will win the next game.


#### Types of Machine Learning problems:

There are two main categories of Machine Learning problems.
* Supervised Learning
* Unsupervised Learning

#### Supervised Learning
 
Given a set of labelled data (where label is a prediction value given some sets of data values), a supervised learning algorithm fits an equation or a shape to the data such that once a new data set is provided it can use the equation to predict a value. There are two main categories of Supervised Learning problems:

* Regression 
* Classification

*Regression* algorithms provide (predicts) continuous valued outputs, while *Classification* algorithms provide discrete valued outputs. 

**Examples**

Given data about the size of houses on the real estate market, try to predict their price. Price as a function of size is a continuous output, so this is a regression problem.

We could turn this example into a classification problem by instead making our output about whether the house "sells for more or less than the asking price." Here we are classifying the houses based on price into two discrete categories.

- Regression - Given a picture of a person, we have to predict their age on the basis of the given picture
- Classification - Given a patient with a tumor, we have to predict whether the tumor is malignant or benign.

