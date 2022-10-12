package com.leetcode.algorithms.MediumMode;

/**
 * HTML entity parser is the parser that takes HTML code as input and replace all the entities of the special characters by the characters itself.
 *
 * The special characters and their entities for HTML are:
 *
 *     Quotation Mark: the entity is &quot; and symbol character is ".
 *     Single Quote Mark: the entity is &apos; and symbol character is '.
 *     Ampersand: the entity is &amp; and symbol character is &.
 *     Greater Than Sign: the entity is &gt; and symbol character is >.
 *     Less Than Sign: the entity is &lt; and symbol character is <.
 *     Slash: the entity is &frasl; and symbol character is /.
 *
 * Given the input text string to the HTML parser, you have to implement the entity parser.
 *
 * Return the text after replacing the entities by the special characters.
 *
 *
 *
 * Example 1:
 *
 * Input: text = "&amp; is an HTML entity but &ambassador; is not."
 * Output: "& is an HTML entity but &ambassador; is not."
 * Explanation: The parser will replace the &amp; entity by &
 *
 * Example 2:
 *
 * Input: text = "and I quote: &quot;...&quot;"
 * Output: "and I quote: \"...\""
 *
 *
 *
 * Constraints:
 *
 *     1 <= text.length <= 105
 *     The string may contain any possible characters out of all the 256 ASCII characters.
 */
public class HTMLEntityParser {

    public String entityParser(String text) {
        /**
         * Runtime: 59 ms, faster than 60.20% of Java online submissions for HTML Entity Parser.
         * Memory Usage: 67.5 MB, less than 43.88% of Java online submissions for HTML Entity Parser.
         */
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < text.length();){
            if(text.charAt(i) == '&'){
                int offset = 7;
                if(i+offset <= text.length() && "&frasl;".equals(text.substring(i, i+offset))){
                    stringBuilder.append("/");
                    i+=offset;
                    continue;
                }
                offset = 6;
                if(i+offset <= text.length()){
                    if("&quot;".equals(text.substring(i, i+offset))){
                        stringBuilder.append("\"");
                        i+=offset;
                        continue;
                    } else if("&apos;".equals(text.substring(i, i+offset))){
                        stringBuilder.append("\'");
                        i+=offset;
                        continue;
                    }
                }
                offset = 5;
                if(i+offset <= text.length()){
                    if("&amp;".equals(text.substring(i, i+offset))){
                        stringBuilder.append("&");
                        i+=offset;
                        continue;
                    }
                }
                offset = 4;
                if(i+offset <= text.length()){
                    if("&gt;".equals(text.substring(i, i+offset))){
                        stringBuilder.append(">");
                        i+=offset;
                        continue;
                    } else if("&lt;".equals(text.substring(i, i+offset))){
                        stringBuilder.append("<");
                        i+=offset;
                        continue;
                    }
                }

            }
            stringBuilder.append(text.charAt(i));
            i++;
        }

        return stringBuilder.toString();
    }


}
