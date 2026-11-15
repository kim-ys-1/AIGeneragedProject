import java.util.Scanner;

public class GradeCalculator {
    private double korean;
    private double math;
    private double english;

    public GradeCalculator() {
        Scanner sc = new Scanner(System.in);
        korean = inputScore(sc, "국어");
        math = inputScore(sc, "수학");
        english = inputScore(sc, "영어");
    }

    private double inputScore(Scanner sc, String subject) {
        System.out.printf("%s 점수를 입력하세요 : ", subject);
        while (true) {
            if (sc.hasNextDouble()) {
                double score = sc.nextDouble();
                if (score < 0 || score > 100) {
                    System.out.print("입력 범위를 넘어갔습니다.\n다시 입력해주세요 : ");
                    continue;
                }
                return score;
            } else {
                System.out.print("숫자가 아닙니다. 다시 입력해주세요 : ");
                sc.next();
            }
        }
    }

    public double getKorean() {
        return korean;
    }

    public double getMath() {
        return math;
    }

    public double getEnglish() {
        return english;
    }

    public double getSum() {
        return getKorean() + getMath() + getEnglish();
    }

    public double getAverage() {
        return getSum() / 3.0;
    }

    public String getGrade() {
        String grade;
        if (getAverage() >= 90) {
            grade = "A";
        } else if (getAverage() >= 80) {
            grade = "B";
        } else if (getAverage() >= 70) {
            grade = "C";
        } else if (getAverage() >= 60) {
            grade = "D";
        } else
            grade = "F";
        return grade;
    }

    public void getPrint() {
        System.out.printf("총점은 %.2f, ", getSum());
        System.out.printf("평균은 %.2f, ", getAverage());
        System.out.printf("학점은 %s", getGrade());
    }
}
