package leo.interview;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CMDTest {

    // write a function to do things like below command
    // cat /tmp/my.txt | grep 'login' | uniq -c | sort -n
    public static void main(String[] args) {
        new CMDTest().findAndCountAndSort("login");
    }


    public Report findAndCountAndSort(String findKey)  {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\git\\my.txt"));
            Map<String, Report> reportMap = new HashMap<String, Report>();
            Report head = null;

            String line = reader.readLine();
            while(line != null) {
                if (line.contains(findKey)) {
                    Report report = reportMap.get(line);
                    if (report == null) {
                        report = new Report();
                        report.line = line;
                        report.count = 1;
                        report.next = null;
                        // insert report into linkedlist;
                        head = insertReport(report, head);
                        reportMap.put(line, report);
                    } else {
                        report.count ++;
                    }
                }
                line = reader.readLine();
            }

            return head;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Report insertReport(Report curr, Report head) {
        if (head == null) {
            head = curr;
            return head;
        }
        Report point = head;
        Report previous = null;
        while(point != null) {
            if (curr.count <= point.count) {
                curr.next = point;
                if (previous != null) {
                    previous.next = curr;
                } else {
                    return curr;
                }
            } else {
                previous = point;
                point = point.next;
            }
        }
        previous.next = curr;
        return head;
    }

    class Report {
        String line;
        int count;
        Report next;
    }
}
