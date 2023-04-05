package hw56;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
Напишите метод для поиска числа в заранее отсортированном по убыванию списке различных целых чисел.
Метод должен вернуть индекс, если элемент найден, и -1, если элемент не найден.
Используйте в качестве образца задачу 2 из классной работы.
 */
public class IndexSearch {

  public static int indexOfNumber(ArrayList<Integer> numbers, int target) {
    int left = 0;
    int right = numbers.size();
    while (right - left > 1) {
      int mid = (left + right) / 2;
      if (numbers.get(mid) == target) {
        return mid;
      }
      if (numbers.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    if (left < numbers.size() && numbers.get(left) == target) {
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
    Collections.sort(numbers, Comparator.reverseOrder());

    for (int number : numbers) {
      System.out.println(number);
    }
  }
}
