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

/**
 * A comparator that allows SimilarityScore to be sorted in
 * ascending order.
 * @author Ralph Allan Rice <ralph.rice@gmail.com>
 *
 */
public class AscendingSimilarityScoreComparator implements Comparator<SimilarityScore>
{
	/**
	 * Compares two similarity scores.
	 * @param x The first score to be compared.
	 * @param y The second score to be compared.
	 * @return a negative integer, zero, or a positive integer as the first score is less than,
	 * equal to, or greater than the second score. 
	 */
	public int compare(SimilarityScore x, SimilarityScore y) {
		double first = x.getScore();
		double second = y.getScore();
		if (first == second) {
			return 0;
		}
		if (first < second) {
			return -1;
		}
		return 1;
	}
	
}
