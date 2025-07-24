public class test {

    public static int solution(String x) {
    	int result = -1;
        int len = x.length();
        for (int i = len; i > 0; i--){
            int n = len / i;
            if (len % i == 0) {
                boolean valid = true;
                String part = x.substring(0, n);
                for (int j = 1; j < i; j++) {
                    if (!x.substring(j * n, j * n + n).equals(part)) {
                        valid = false;
                        break;
                    }
                }
                if (valid){
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(solution("abccbaabccba"));

    }
}
