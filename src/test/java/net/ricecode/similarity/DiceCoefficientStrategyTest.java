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

public class DiceCoefficientStrategyTest {

	@Test
	public void testOneTranspostion() {
		SimilarityStrategy s = new DiceCoefficientStrategy();
		String first = "Martha";
		String second = "Marhta";
		double expected = 0.400;
		double delta = 0.001;
		double actual = s.score(first, second);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testSoundAlike() {
		SimilarityStrategy s = new DiceCoefficientStrategy();
		String first = "Dwayne";
		String second = "Duane";
		double expected = 0.2222;
		double delta = 0.001;
		double actual = s.score(first, second);
		assertEquals(expected, actual, delta);
		
	}
	
	@Test
	public void testMisspelledSoundAlike() {
		SimilarityStrategy s = new DiceCoefficientStrategy();
		String first = "Dixon";
		String second = "Dicksonx";
		double expected = 0.363636;
		double delta = 0.001;
		double actual = s.score(first, second);
		assertEquals(expected, actual, delta);
		
	}
	
	@Test
	public void testAbsoluteSimilarity() {
		SimilarityStrategy s = new DiceCoefficientStrategy();
		String first = "Mississippi";
		String second = "Mississippi";
		double expected = 1.000;
		double delta = 0.000;
		double actual = s.score(first, second);
		assertEquals(expected, actual, delta);
	}
	
	@Test
	public void testAbsoluteDissimilarity() {
		SimilarityStrategy s = new DiceCoefficientStrategy();
		String first = "Mississippi";
		String second = "Oklahoma";
		double expected = 0.000;
		double delta = 0.000;
		double actual = s.score(first, second);
		assertEquals(expected, actual, delta);
	}

}
