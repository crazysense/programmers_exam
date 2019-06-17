package cracking_the_coding_interview.ch_01_array_and_string;

// 특정문자치환
// 문자바꾸기
public class Replace {
    public static void main(String[] args) {
        char[] arr = new char[100];
        String str = "hello world my test ";
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        print(arr);

        Solution01 sol01 = new Solution01();
        sol01.replace(arr, str.length());
        System.out.println("========>");
        print(arr);

        //
        arr = new char[100];
        str = "hello world my test ";
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        Solution02 sol02 = new Solution02();
        sol02.replace(arr, str.length(), "_SPACE_".toCharArray());
        System.out.println("========>");
        print(arr);
    }

    static void print(char[] arr) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (arr[idx] != '\0') {
            if (idx > 0) sb.append(", ");
            sb.append(arr[idx++]);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    static class Solution01 {
        void replace(char[] str, int len) {
            int spaceCount = 0;
            for (int i = 0; i < len; i++) {
                if (str[i] == ' ') spaceCount++;
            }

            int newLen = len + (("%20".length() - " ".length()) * spaceCount);
            str[newLen--] = '\0';
            for (int i = len - 1; i >= 0; i--) {
                if (str[i] == ' ') {
                    str[newLen--] = '0';
                    str[newLen--] = '2';
                    str[newLen--] = '%';
                } else {
                    str[newLen--] = str[i];
                }
            }
        }
    }

    static class Solution02 {
        void replace(char[] str, int len, char[] replaceStr) {
            int spaceCount = 0;
            for (int i = 0; i < len; i++) {
                if (str[i] == ' ') spaceCount++;
            }

            int newLen = len + ((replaceStr.length - " ".length()) * spaceCount);
            str[newLen--] = '\0';
            for (int i = len - 1; i >= 0; i--) {
                if (str[i] == ' ') {
                    for (int j = replaceStr.length - 1; j >= 0; j--) {
                        str[newLen--] = replaceStr[j];
                    }
                } else {
                    str[newLen--] = str[i];
                }
            }
        }
    }
}
