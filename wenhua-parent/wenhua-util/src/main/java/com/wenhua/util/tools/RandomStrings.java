package com.wenhua.util.tools;

import java.util.Random;

/**
 * Operations for random {@code String}s.
 * <p/>
 * Currently <em>private high surrogate</em> characters are ignored.
 * These are Unicode characters that fall between the values 56192 (db80)
 * and 56319 (dbff) as we don't know how to handle them.
 * High and low surrogates are correctly dealt with - that is if a
 * high surrogate is randomly chosen, 55296 (d800) to 56191 (db7f)
 * then it is followed by a low surrogate. If a low surrogate is chosen,
 * 56320 (dc00) to 57343 (dfff) then it is placed after a randomly
 * chosen high surrogate.
 * <p/>
 * #ThreadSafe#
 *
 * @author ggregory
 * @author Apache Software Foundation (ASF)
 * @since 1.0
 * @version $Id: RandomStrings.java 27644 2013-05-13 10:57:55Z C629 $
 */
public final class RandomStrings {

    /**
     * Random object used by random method. This has to be not local
     * to the random method so as to not return the same value in the
     * same millisecond.
     */
    private static final Random RANDOM = new Random();

    /**
     * Creates a random string whose length is the number of characters
     * specified.
     * <p/>
     * Characters will be chosen from the set of all characters.
     *
     * @param count the length of random string to create
     * @return the random string
     */
    public static String random(int count) {
        return random(count, false, false);
    }

    /**
     * Creates a random string whose length is the number of characters
     * specified.
     * <p/>
     * Characters will be chosen from the set of characters whose
     * ASCII value is between {@code 32} and {@code 126} (inclusive).
     *
     * @param count the length of random string to create
     * @return the random string
     */
    public static String randomAscii(int count) {
        return random(count, 32, 127, false, false);
    }

    /**
     * Creates a random string whose length is the number of characters
     * specified.
     * <p/>
     * Characters will be chosen from the set of alphabetic
     * characters.
     *
     * @param count the length of random string to create
     * @return the random string
     */
    public static String randomAlphabetic(int count) {
        return random(count, true, false);
    }

    /**
     * Creates a random string whose length is the number of characters
     * specified.
     * <p/>
     * Characters will be chosen from the set of alpha-numeric
     * characters.
     *
     * @param count the length of random string to create
     * @return the random string
     */
    public static String randomAlphanumeric(int count) {
        return random(count, true, true);
    }

    /**
     * Creates a random string whose length is the number of characters
     * specified.
     * <p/>
     * Characters will be chosen from the set of numeric
     * characters.
     *
     * @param count the length of random string to create
     * @return the random string
     */
    public static String randomNumeric(int count) {
        return random(count, false, true);
    }

    /**
     * Creates a random string whose length is the number of characters
     * specified.
     * <p/>
     * Characters will be chosen from the set of alpha-numeric
     * characters as indicated by the arguments.
     *
     * @param count   the length of random string to create
     * @param letters if {@code true}, generated string will include
     *                alphabetic characters
     * @param numbers if {@code true}, generated string will include
     *                numeric characters
     * @return the random string
     */
    public static String random(int count, boolean letters, boolean numbers) {
        return random(count, 0, 0, letters, numbers);
    }

    /**
     * Creates a random string whose length is the number of characters
     * specified.
     * <p/>
     * Characters will be chosen from the set of alpha-numeric
     * characters as indicated by the arguments.
     *
     * @param count   the length of random string to create
     * @param start   the position in set of chars to start at
     * @param end     the position in set of chars to end before
     * @param letters if {@code true}, generated string will include
     *                alphabetic characters
     * @param numbers if {@code true}, generated string will include
     *                numeric characters
     * @return the random string
     */
    public static String random(int count, int start, int end, boolean letters, boolean numbers) {
        return random(count, start, end, letters, numbers, null, RANDOM);
    }

    /**
     * Creates a random string based on a variety of options, using
     * default source of randomness.
     * <p/>
     * This method has exactly the same semantics as
     * {@link #random(int, int, int, boolean, boolean, char[], java.util.Random)}, but
     * instead of using an externally supplied source of randomness, it uses
     * the internal static {@link java.util.Random} instance.
     *
     * @param count   the length of random string to create
     * @param start   the position in set of chars to start at
     * @param end     the position in set of chars to end before
     * @param letters only allow letters?
     * @param numbers only allow numbers?
     * @param chars   the set of chars to choose randoms from.
     *                If {@code null}, then it will use the set of all chars.
     * @return the random string
     * @throws ArrayIndexOutOfBoundsException if there are not
     *                                        {@code (end - start) + 1} characters in the set array.
     */
    public static String random(int count, int start, int end, boolean letters, boolean numbers, char... chars) {
        return random(count, start, end, letters, numbers, chars, RANDOM);
    }

    /**
     * Creates a random string based on a variety of options, using
     * supplied source of randomness.
     * <p/>
     * If start and end are both {@code 0}, start and end are set
     * to {@code ' '} and {@code 'z'}, the ASCII printable
     * characters, will be used, unless letters and numbers are both
     * {@code false}, in which case, start and end are set to
     * {@code 0} and {@code Integer.MAX_VALUE}.
     * <p/>
     * If set is not {@code null}, characters between start and
     * end are chosen.
     * <p/>
     * This method accepts a user-supplied {@link java.util.Random}
     * instance to use as a source of randomness. By seeding a single
     * {@link java.util.Random} instance with a fixed seed and using it for each call,
     * the same random sequence of strings can be generated repeatedly
     * and predictably.
     *
     * @param count   the length of random string to create
     * @param start   the position in set of chars to start at
     * @param end     the position in set of chars to end before
     * @param letters only allow letters?
     * @param numbers only allow numbers?
     * @param chars   the set of chars to choose randoms from.
     *                If {@code null}, then it will use the set of all chars.
     * @param random  a source of randomness.
     * @return the random string
     * @throws ArrayIndexOutOfBoundsException if there are not
     *                                        {@code (end - start) + 1} characters in the set array.
     * @throws IllegalArgumentException       if {@code count} &lt; 0.
     * @since 2.0
     */
    public static String random(int count, int start, int end, boolean letters, boolean numbers,
                                char[] chars, Random random) {
        if (count == 0) {
            return "";
        } else if (count < 0) {
            throw new IllegalArgumentException("Requested random string length " + count + " is less than 0.");
        }
        if (start == 0 && end == 0) {
            end = 'z' + 1;
            start = ' ';
            if (!letters && !numbers) {
                start = 0;
                end = Integer.MAX_VALUE;
            }
        }

        char[] buffer = new char[count];
        int gap = end - start;

        while (count-- != 0) {
            char ch;
            if (chars == null) {
                ch = (char) (random.nextInt(gap) + start);
            } else {
                ch = chars[random.nextInt(gap) + start];
            }
            if (letters && Character.isLetter(ch)
                    || numbers && Character.isDigit(ch)
                    || !letters && !numbers) {
                if (ch >= 56320 && ch <= 57343) {
                    if (count == 0) {
                        count++;
                    } else {
                        // low surrogate, insert high surrogate after putting it in
                        buffer[count] = ch;
                        count--;
                        buffer[count] = (char) (55296 + random.nextInt(128));
                    }
                } else if (ch >= 55296 && ch <= 56191) {
                    if (count == 0) {
                        count++;
                    } else {
                        // high surrogate, insert low surrogate before putting it in
                        buffer[count] = (char) (56320 + random.nextInt(128));
                        count--;
                        buffer[count] = ch;
                    }
                } else if (ch >= 56192 && ch <= 56319) {
                    // private high surrogate, no effing clue, so skip it
                    count++;
                } else {
                    buffer[count] = ch;
                }
            } else {
                count++;
            }
        }
        return new String(buffer);
    }

    /**
     * Creates a random string whose length is the number of characters
     * specified.
     * <p/>
     * Characters will be chosen from the set of characters
     * specified.
     *
     * @param count the length of random string to create
     * @param chars the String containing the set of characters to use,
     *              may be null
     * @return the random string
     * @throws IllegalArgumentException if {@code count} &lt; 0.
     */
    public static String random(int count, String chars) {
        if (chars == null) {
            return random(count, 0, 0, false, false, null, RANDOM);
        }
        return random(count, chars.toCharArray());
    }

    /**
     * Creates a random string whose length is the number of characters
     * specified.
     * <p/>
     * Characters will be chosen from the set of characters specified.
     *
     * @param count the length of random string to create
     * @param chars the character array containing the set of characters to use,
     *              may be null
     * @return the random string
     * @throws IllegalArgumentException if {@code count} &lt; 0.
     */
    public static String random(int count, char... chars) {
        if (chars == null) {
            return random(count, 0, 0, false, false, null, RANDOM);
        }
        return random(count, 0, chars.length, false, false, chars, RANDOM);
    }
}
