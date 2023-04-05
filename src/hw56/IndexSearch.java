package hw56;

import java.util.ArrayList;

/*
Напишите метод для поиска числа в заранее отсортированном по убыванию списке различных целых чисел.
Метод должен вернуть индекс, если элемент найден, и -1, если элемент не найден.
Используйте в качестве образца задачу 2 из классной работы.
 */
public class IndexSearch {
  public static int indexOfNumber(ArrayList<Integer> numbers, int target) {
    int left = 0;
    int right = numbers.size();
    while (right - left >  1) {
      int mid = (left + right)/2;
      if (numbers.get(mid) == target) {
        return mid;
      }
      if (numbers.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid + 1;
      } else {
        right = mid;
      }
    }
    if (left < numbers.size() && numbers.get(left) == target) {
      return left;
    }
    return -1;
  }
}
