
[![License: MIT](https://img.shields.io/github/license/rrice/java-string-similarity)](https://opensource.org/licenses/MIT)
[![Issues](https://img.shields.io/github/issues/rrice/java-string-similarity)](https://github.com/rrice/java-string-similarity/actions)
![Java CI](https://github.com/rrice/java-string-similarity/workflows/Java%20CI%20with%20Gradle/badge.svg)


[java-string-similarity](https://github.com/rrice/java-string-similarity) that calculates a normalized distance or similarity score between two strings. A score of 0.0 means that the two strings are absolutely dissimilar, and 1.0 means that absolutely similar (or equal). Anything in between indicates how similar each the two strings are.

Example
-------

In this simple example, we want to calculate a similarity score between the words `McDonalds` and `MacMahons`. We are selecting the [Jaro-Winkler distance algorithm](http://www.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance) algorithm.

```java
SimilarityStrategy strategy = new JaroWinklerStrategy();
String target = "McDonalds";
String source = "MacMahons";
StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
double score = service.score(source, target); // Score is 0.90
```

Algorithms
----------

* [Jaro distance](http://www.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance)
* [Jaro-Winkler distance](http://www.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance)
* [Levenshtein distance](http://www.wikipedia.org/wiki/Levenshtein_distance)
* [Sørensen–Dice coefficient](http://www.wikipedia.org/wiki/Sørensen–Dice_coefficient)


Installation
------------

This project currently uses [Maven](http://maven.apache.org/) for management. You can compile, test and install the component to your local repo by calling:

```
mvn install
```

Then, you can add this component to your project by adding a dependency:

```
<dependency>
    <groupId>net.ricecode</groupId>
	<artifactId>string-similarity</artifactId>
	<version>1.0.0</version>
</dependency>
```

TODO
----

* Ant/Ivy build scripts.

* [Jaccard index](http://www.wikipedia.org/wiki/Jaccard_index)

