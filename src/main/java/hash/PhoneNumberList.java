package hash;

public class PhoneNumberList {
    public static void main(String[] args) {
        PhoneNumberList sol = new PhoneNumberList();
        String[] phoneNumbers = new String[]{"119", "97674223", "1195524421"};
        System.out.println(sol.solution(phoneNumbers));
    }

    public boolean solution(String[] p) {
        boolean answer = true;
        for (int i = 0; i < p.length - 1; i++) {
            for (int j = i + 1; j < p.length; j++) {
                if (p[j].startsWith(p[i])) return false;
                if (p[i].startsWith(p[j])) return false;
            }
        }
        return answer;
    }
}
