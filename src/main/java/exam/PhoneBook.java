package exam;

// 전화번호부
// 같은 숫자가 prefix 로 나오는지
public class PhoneBook {
    public static void main(String[] args) {
        String[] phone_book = new String[]{
                "119", "97674223", "1195524421"
        };

        System.out.println(solution1(phone_book));
    }

    static boolean solution1(String[] phone_book) {
        // 정렬해서 한번에 할수도 있음
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) return false;
                if (phone_book[i].startsWith(phone_book[j])) return false;
            }
        }
        return true;
    }
}
