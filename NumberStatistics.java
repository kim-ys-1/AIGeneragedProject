import java.util.Scanner;

public class NumberStatistics {
    int[] numList = new int[10];

    public NumberStatistics() {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 10개를 입력하세요 : ");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + "번째 숫자 : ");
            while (true) {
                if (sc.hasNextInt()) {
                    numList[i] = sc.nextInt();
                    break;
                }
                else {
                    System.out.print("숫자가 아닙니다. 다시 입력해주세요 : ");
                    sc.next();
                }
            }
        }
        sc.close();
    }

    public void printList() {
        System.out.print("[ ");
        for (int i = 0; i < 10; i++) {
            System.out.print(numList[i] + " ");
        }
        System.out.print("]");
    }

    public int[] getSort() {
        int[] sorted = new int[10];
        for (int i = 0; i < 10; i++) {
            sorted[i] = numList[i];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 - i; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }

    public void printSortList() {
        int[] sorted = getSort();

        System.out.print("[ ");
        for (int num : sorted) {
            System.out.print(num + " ");
        }
        System.out.print("]");
    }

    public int maxNum() {
        int[] sorted = getSort();
        return sorted[9];
    }

    public int minNum() {
        int[] sorted = getSort();
        return sorted[0];
    }

    public int Sum() {
        int total = 0;
        for (int i = 0; i < 10; i++)
            total += numList[i];
        return total;
    }

    public int evenCount() {
        int count = 0;
        for (int num : numList) {
            if (num % 2 == 0)
                count++;
        }
        return count;
    }

    public int oddCount() {
        int count = 0;
        for (int num : numList) {
            if (num % 2 != 0)
                count++;
        }
        return count;
    }

    public void printStatistics() {
        System.out.print("입력한 숫자 : ");
        printList();
        System.out.print("\n오름차순 : ");
        printSortList();
        System.out.printf("\n최댓값 : %d", maxNum());
        System.out.printf("\n최솟값 : %d", minNum());
        System.out.printf("\n합계 : %d", Sum());
        System.out.printf("\n짝수 : %d개", evenCount());
        System.out.printf("\n홀수 : %d개", oddCount());
    }
}
