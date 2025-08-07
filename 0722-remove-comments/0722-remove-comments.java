class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder lineBuffer = new StringBuilder();
        boolean inBlockComment = false;

        for (String line : source) {
            int i = 0;
            if (!inBlockComment) {
                lineBuffer = new StringBuilder();  // Start a new line only if not in block comment
            }

            while (i < line.length()) {
                if (inBlockComment) {
                    // Look for end of block comment
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlockComment = false;
                        i += 2; // Skip "*/"
                    } else {
                        i++; // Skip current character
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        // Line comment starts, ignore rest of line
                        break;
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        // Start of block comment
                        inBlockComment = true;
                        i += 2; // Skip "/*"
                    } else {
                        // Normal character
                        lineBuffer.append(line.charAt(i));
                        i++;
                    }
                }
            }

            // Only add the line if we're not in a block comment and the buffer is non-empty
            if (!inBlockComment && lineBuffer.length() > 0) {
                result.add(lineBuffer.toString());
            }
        }

        return result;
    }
}
