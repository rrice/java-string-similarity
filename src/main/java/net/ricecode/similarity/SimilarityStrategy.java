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

/**
 * @author Ralph Allan Rice <ralph.rice@gmail.com>
 * An interface that defines methods to perform string similarity calculation.
 */
public interface SimilarityStrategy {

	/**
	 * Calculates the similarity score of objects, where 0.0 implies absolutely no similarity
	 * and 1.0 implies absolute similarity.
	 * 
	 * @param first The first string to compare.
	 * @param second The second string to compare.
	 * @return A number between 0.0 and 1.0.
	 */
    double score(String first, String second);
}
