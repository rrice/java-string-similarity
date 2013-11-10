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
 * A strategy that uses the Jaro Distance to calculate the similarity of two strings.
 * @author Ralph Allan Rice <ralph.rice@gmail.com>
 * @see <a href="http://en.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance">About Jaro Distance</a>
 */
public class JaroStrategy implements SimilarityStrategy {

	/**
	 * Calculates the similarity score of objects, where 0.0 implies absolutely no similarity
	 * and 1.0 implies absolute similarity.
	 * 
	 * @param first The first string to compare.
	 * @param second The second string to compare.
	 * @return A number between 0.0 and 1.0.
	 */
    public double score(String first, String second) {
		String shorter;
        String longer;

        // Determine which String is longer.
        if (first.length() > second.length())
        {
            longer = first.toLowerCase();
            shorter = second.toLowerCase();
        }
        else
        {
            longer = second.toLowerCase();
            shorter = first.toLowerCase();
        }

        // Calculate the half length() distance of the shorter String.
        int halflength = (shorter.length() / 2) + 1;

        // Find the set of matching characters between the shorter and longer strings. Note that
        // the set of matching characters may be different depending on the order of the strings.
        String m1 = getSetOfMatchingCharacterWithin(shorter, longer, halflength);
        String m2 = getSetOfMatchingCharacterWithin(longer, shorter, halflength);


        // If one or both of the sets of common characters is empty, then 
        // there is no similarity between the two strings.
        if (m1.length() == 0 || m2.length() == 0) return 0.0;

        // If the set of common characters is not the same size, then
        // there is no similarity between the two strings, either.
        if (m1.length() != m2.length()) return 0.0;

        // Calculate the number of transpositions between the two sets
        // of common characters.
        int transpositions = transpositions(m1, m2);

        // Calculate the distance.
        double dist =
                (m1.length() / ((double)shorter.length()) +
                m2.length() / ((double)longer.length()) +
                (m1.length() - transpositions) / ((double)m1.length())) / 3.0;
        return dist;

	
	}
	
	/**
	 * Gets a set of matching characters between two strings.
	 * 
	 * @param first The first string.
	 * @param second The second string.
	 * @param limit The maximum distance to consider.
	 * @return A string contain the set of common characters.
	 * @remarks Two characters from the first string and the second string are considered matching if the character's
     * respective positions are no farther than the limit value.
	 */
	private String getSetOfMatchingCharacterWithin(String first, String second, int limit)
    {

        StringBuilder common = new StringBuilder();
        StringBuilder copy = new StringBuilder(second);
        for (int i = 0; i < first.length(); i++)
        {
            char ch = first.charAt(i);
            boolean found = false;

            // See if the character is within the limit positions away from the original position of that character.
            for (int j = Math.max(0, i - limit); !found && j < Math.min(i + limit, second.length()); j++)
            {
                if (copy.charAt(j) == ch)
                {
                    found = true;
                    common.append(ch);
                    copy.setCharAt(j,'*');
                }
            }
        }
        return common.toString();
    }

	/**
	 * Calculates the number of transpositions between two strings.
	 * @param first The first string.
	 * @param second The second string.
	 * @return The number of transpositions between the two strings.
	 */
    private int transpositions(String first, String second)
    {
        int transpositions = 0;
        for (int i = 0; i < first.length(); i++)
        {
            if (first.charAt(i) != second.charAt(i))
            {
                transpositions++;
            }
        }
        transpositions /= 2;
        return transpositions;
    }

}
