package hw56;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
Напишите метод для поиска числа в заранее отсортированном по убыванию списке различных целых чисел.
Метод должен вернуть индекс, если элемент найден, и -1, если элемент не найден.
Используйте в качестве образца задачу 2 из классной работы.
 */
public class IndexSearch {

  public static int indexOfNumber(ArrayList<Integer> descendingNumbers, int target) {
    int left = 0;
    int right = descendingNumbers.size();
    while (left < right - 1) {
      int mid = (left + right) / 2;
      if (descendingNumbers.get(mid) == target) {
        return mid;
      }
      if (descendingNumbers.get(mid) > target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (left < descendingNumbers.size() && descendingNumbers.get(left) == target) {
      return left;
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter elements' numbers: ");
    int n = scanner.nextInt();

    ArrayList<Integer> numbers = new ArrayList<>(n);
    for (int i = 0; i < n; ++i) {
      numbers.add(scanner.nextInt());
    }
    // сортируем список в порядке убывания
    numbers.sort(Comparator.reverseOrder());

    for (int number : numbers) {
      System.out.println(number);
    }

    System.out.print("Enter number for search: ");
    int target = scanner.nextInt();

    System.out.print("Result: " + indexOfNumber(numbers, target));
  }
}
