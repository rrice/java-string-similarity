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

import static org.junit.Assert.*;

import org.junit.Test;

public class AscendingComparatorTest {

	@Test
	public void testCompareScoreFirstGreater() {
		SimilarityScore first = new SimilarityScore("First", 0.87);
		SimilarityScore second = new SimilarityScore("Second", 0.54);
		AscendingSimilarityScoreComparator c = new AscendingSimilarityScoreComparator();
		assertTrue(c.compare(first, second)>0);
		assertTrue(c.compare(second, first)<0);
	}
	
	@Test
	public void testCompareScoreSecondGreater() {
		SimilarityScore first = new SimilarityScore("First", 0.37);
		SimilarityScore second = new SimilarityScore("Second", 0.65);
		AscendingSimilarityScoreComparator c = new AscendingSimilarityScoreComparator();
		assertTrue(c.compare(first, second)<0);
		assertTrue(c.compare(second, first)>0);
	}

	@Test
	public void testCompareScoreEquality() {
		SimilarityScore first = new SimilarityScore("First", 0.96);
		SimilarityScore second = new SimilarityScore("Second", 0.96);
		AscendingSimilarityScoreComparator c = new AscendingSimilarityScoreComparator();
		assertEquals(c.compare(first, second), 0);
		assertEquals(c.compare(second, first), 0);
	}

}
