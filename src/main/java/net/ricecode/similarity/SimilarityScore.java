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
 * A value object contains a similarity score.
 * @author Ralph Allan Rice <ralph.rice@gmail.com>
 * 
 */
public class SimilarityScore {
	
	private String key;
	private double score;
	
	/**
	 * Constructs a similarity score.
	 * @param key The string key.
	 * @param score The score value.
	 */

	public SimilarityScore(String key, double score) {
		this.key = key;
		this.score = score;
	}
	
	/**
	 * Gets the key for this score.
	 * @return A string.
	 */
	public String getKey() {
		return this.key;
	}
	
	/**
	 * Gets the value of the score.
	 * @return A double.
	 */
	public double getScore() {
		return this.score;
	}

	
	/**
	 * Returns the hash code for this object.
	 * @return An integer representing the hash code.
	 */
	public int hashCode() {
		int hash = 11;
		hash = 23 * hash + key.hashCode(); 
		hash = 23 * hash + (int)(score * 1000000);
		return hash;
	}
	
	/**
	 * Determines if the supplied object equals this object.
	 * @return True if the keys and scores match between the two objects. Otherwise false.
	 */
	@Override
	public boolean equals(Object o) {
		if((o == null) || (o.getClass() != this.getClass())) {
			return false; 
		}
		SimilarityScore other=(SimilarityScore)o;
		
		return this.key.equals(other.key)
					&& this.score == other.score;
	}
	
	
}
