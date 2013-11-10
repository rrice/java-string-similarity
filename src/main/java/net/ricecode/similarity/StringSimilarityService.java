/*
 * Copyright (c) 2010 Ralph Allan Rice <ralph.rice@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 */

package net.ricecode.similarity;

import java.util.Comparator;
import java.util.List;

/**
 * A service that performs string similarity calculations.
 * @author Ralph Allan Rice <ralph.rice@gmail.com>
 *
 */
public interface StringSimilarityService {

	/**
     * Calculates all similarity scores for a given set of features.
     * @param features The list of features.
     * @param target The target string to compare against the features.
     * @return A list of similarity scores.
     */
    List<SimilarityScore> scoreAll(List<String> features, String target);
	
    /**
     * Calculates the similarity score of a single feature.
     * @param feature The feature string to compare.
     * @param target The target string to compare against the feature.
     * @return The similarity score between the feature and target.
     */
    double score(String feature, String target);

    
    /**
     * Finds the feature within a set of given features that best match the target string.
     * @param features A list of strings containing the features to compare.
     * @param target The target string to compare against the features.
     * @return A SimilarityScore that has the highest score value amongst the features.
     */
    SimilarityScore findTop(List<String> features, String target);

    /**
     * Finds the feature within a set of given features that best match the target string.
     * @param features A list of strings containing the features to compare.
     * @param target The target string to compare against the features.
     * @param comparator A comparator that is used sort the scores.  
     * @return A SimilarityScore that has the top value amongst the features, according to the comparator.
     */
    SimilarityScore findTop(List<String> features, String target, Comparator<SimilarityScore> comparator);
}
