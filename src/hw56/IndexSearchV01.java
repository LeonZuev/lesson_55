package hw56;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class IndexSearchV01 {
// Бинарный поиск работает только с сортированным списком, поэтому только эррэй лист
  /**
   * Поиск элемента в отсортированном по убыванию списке
   * @param descendingNumbers отсортированный по убыванию список различных целых чисел
   * @param target число, которое необходимо найти
   * @return индекс числа в списке или -1, если число не найдено
   */
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
    System.out.print("Enter elements' numbers throw space: ");
    String inputLine = scanner.nextLine();
    String[] input = inputLine.split(" ");
    ArrayList<Integer> numbers = new ArrayList<>(input.length);
    for (String n : input) {
      numbers.add(Integer.parseInt(n)); // O(n)
    }
    // сортируем список в порядке убывания
    Collections.sort(numbers, Comparator.reverseOrder());

    for (int number : numbers) {
      System.out.print("[" + number + "] ");
    }

    System.out.print("Enter number for search: ");
    int target = scanner.nextInt();

    System.out.print("Result: " + indexOfNumber(numbers, target));
  }
}
