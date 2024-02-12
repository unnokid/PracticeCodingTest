package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2596 {
    public static void main(String[] args) throws IOException {
        //백준 2596 비밀편지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String arr[] = new String[n];
        String s = br.readLine();

        String code[] = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};
        String key[] = {"A", "B", "C", "D", "E", "F", "G", "H"};

        for (int i = 0; i < s.length(); i += 6) {
            if (i + 6 > s.length()){
                break;
            }
            arr[i / 6] = s.substring(i, i + 6);
        }

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < code.length; j++) {
                if (code[j].equals(arr[i])) {
                    sb.append(key[j]);
                    flag = true;
                    break;
                }
                else {
                    int cnt = 0;
                    for (int z = 0; z < 6; z++) {
                        if (code[j].charAt(z) != arr[i].charAt(z)) {
                            if (cnt >= 1) {
                                flag = false;
                                break;
                            }
                            cnt++;
                        } else {
                            flag = true;
                        }
                    }

                    if (flag) {
                        sb.append(key[j]);
                        break;
                    }
                }


            }
            if (!flag) {
                sb.setLength(0);
                System.out.println(i + 1);
                break;
            }
        }

        System.out.println(sb);

    }
}
