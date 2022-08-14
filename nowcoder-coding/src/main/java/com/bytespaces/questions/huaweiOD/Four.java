package com.bytespaces.questions.huaweiOD;

import java.util.ArrayList;
import java.util.Scanner;

public class Four {
    /**
     * 缺勤
     */
    private static final String ABSENT = "absent";
    /**
     * 迟到
     */
    private static final String LATE = "late";
    /**
     * 早退
     */
    private static final String LEAVEEARLY = "leaveearly";
    /**
     * 正常上班
     */
    private static final String PRESENT = "present";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 记录数
        int total = scanner.nextInt();
        ArrayList<String> list = new ArrayList<>();

        scanner.nextLine();
        for (int i = 0; i < total; i++) {
            list.add(scanner.nextLine());
        }
        for (int i = 0; i < list.size(); i++) {
            int absentCount = 0;
            boolean flag = true;
            String str = list.get(i);
            String[] split = str.split(" ");

            for (int i1 = 0; i1 < split.length; i1++) {
                if (split[i1].equals("absent")){
                    absentCount++;
                    if (absentCount == 2){
                        flag = false;
                        break;
                    }
                }
                if (split[i1].equals("late") || split[i1].equals("leaveearly")){
                    if (i1+1 < split.length && (split[i1 + 1].equals("late") || split[i1 + 1].equals("leaveearly"))){
                        flag = false;
                        break;
                    }
                }
                if (!split[i1].equals("present")){
                    int failCount = 1;
                    for (int j = 1; j < 7 && i1 + j < split.length; j++) {
                        if (!split[i1+j].equals("present")) {
                            failCount++;
                        }
                    }
                    if (failCount > 3){
                        flag = false;
                        break;
                    }
                }
            }

            System.out.print(flag + " ");
        }
    }
}
