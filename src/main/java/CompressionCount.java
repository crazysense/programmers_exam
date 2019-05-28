public class CompressionCount {
    public static void main(String[] args) {
        String s1 = "abcdaaabbbcccddddddeeeeeeffffff";
        System.out.println(compress(s1));
        System.out.println(compress2(s1));

        String s2 = "aaa";
        System.out.println(compress(s2));
        System.out.println(compress2(s2));
    }

    static int compressCount(String str) {
        if (str == null || str.isEmpty()) return 0;
        char c = str.charAt(0);
        int size = 0, count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            } else {
                c = str.charAt(i);
                size += String.valueOf(count).length() + 1;
                count = 1;
            }
        }
        size += String.valueOf(count).length() + 1;
        return size;
    }

    static String compress(String str) {
        int size = compressCount(str);
        if (size >= str.length()) return str;

        int count = 1;
        StringBuffer buffer = new StringBuffer();
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            } else {
                buffer.append(c).append(count);
                c = str.charAt(i);
                count = 1;
            }
        }
        buffer.append(c).append(count);
        return buffer.toString();
    }

    static String compress2(String str) {
        StringBuffer buffer = new StringBuffer();
        int size = 0;
        if (str.length() > 0) {
            int count = 1;
            char c = str.charAt(0);
            for (int i = 1; i < str.length() && size < str.length(); i++) {
                if (str.charAt(i) == c) {
                    count++;
                } else {
                    buffer.append(c).append(count);
                    c = str.charAt(i);
                    size += String.valueOf(count).length() + 1;
                    count = 1;
                }
            }
            buffer.append(c).append(count);
            size += String.valueOf(count).length() + 1;
        }
        return size >= str.length() ? str : buffer.toString();
    }
}
