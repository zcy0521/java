import java.time.LocalDate;

public class DateTest {

    public static void main(String[] args) {
        // 今天是 几月几号
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        // 当前月第一天是星期几
        date = date.minusDays(today - 1);
        int week = date.getDayOfWeek().getValue();

        // 头
        System.out .println("Mon Tue Wed Thu Fri Sat Sun ");

        // 确定第一天位置
        // 第一天是周一不打印空格
        // 第一天是周二打印4个空格，每个单元4个空格
        for (int i = 1; i < week; i++) {
            System.out.print("    ");
        }

        // 循环打印当前月日期
        while (date.getMonthValue() == month) {
            if (date.getDayOfMonth() == today) {
                // 当天 22*
                System.out.printf("%3d*", date.getDayOfMonth());
            } else {
                // 其他后面空格分开
                System.out.printf("%3d ", date.getDayOfMonth());
            }

            // 日期加1天
            date = date.plusDays(1);

            // 周1换行
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
    }

}
