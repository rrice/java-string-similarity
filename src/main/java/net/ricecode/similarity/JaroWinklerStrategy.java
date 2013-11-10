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
 * A strategy that uses the Jaro-Winkler Distance to calculate the similarity of two strings.
 * 
 * @author Ralph Allan Rice <ralph.rice@gmail.com>
 * @see <a href="http://en.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance">About Jaro-Wrinkler Distance</a>
 */
public class JaroWinklerStrategy extends JaroStrategy implements SimilarityStrategy {
	final double DEFAULT_SCALING_FACTOR = 0.1;  // This is the default scaling factor Winkler used.

    private double scalingFactor;
    
    /**
     * Constructs a new JaroWinklerStrategy instance.
     * @param scalingFactor The scaling factor between 0.00 and 0.25. If the scaling factor is greater than 0.25, the scaling factor is set to 0.25.
     */
    public JaroWinklerStrategy(double scalingFactor)
    {
        if (scalingFactor > 0.25)
        {
            scalingFactor = 0.25;    
        }
        this.scalingFactor = scalingFactor;
    }

    /**
     * Constructs a new JaroWinklerStrategy instance.
     */
    public JaroWinklerStrategy()
    {
        this.scalingFactor = DEFAULT_SCALING_FACTOR;
    }

    /**
	 * Calculates the similarity score of objects, where 0.0 implies absolutely no similarity
	 * and 1.0 implies absolute similarity.
	 * 
	 * @param first The first string to compare.
	 * @param second The second string to compare.
	 * @return A number between 0.0 and 1.0.
	 */
    public double score(String first, String second)
    {
        double jaro = super.score(first, second);

        int cl = commonPrefixLength(first, second);

        // The Jaro–Winkler distance uses a prefix scale which gives more favorable ratings
        // to strings that match from the beginning for a set prefix length.
        double winkler = jaro + (scalingFactor * cl * (1.0 - jaro));

        return winkler;

    }

    /**
     * Calculates the number of characters from the beginning of the strings that match exactly one-to-one, 
     * up to a maximum of four (4) characters.
     * @param first The first string.
     * @param second The second string.
     * @return A number between 0 and 4.
     */
    private int commonPrefixLength(String first, String second)
    {
        String shorter;
        String longer;

        // Determine which string is longer.
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

        int result = 0;

        // Iterate through the shorter string.
        for (int i = 0; i < shorter.length(); i++)
        {
            if (shorter.charAt(i) != longer.charAt(i))
            {
                break;
            }
            result++;
        }

        // Limit the result to 4.
        return result > 4? 4: result;
    }

	
}
