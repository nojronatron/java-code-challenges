package myJava.code.challenges;

import java.util.Hashtable;

public class AnagramExpert {
  private final Hashtable<Character, Integer> hashtable;

  public AnagramExpert() {
    this.hashtable = new Hashtable<>();
  }

  public boolean isAnagram(String word1, String word2) {
    var firstInput = word1.replaceAll("\\W", "");
    var secondInput = word2.replaceAll("\\W", "");

    if (firstInput.length() != secondInput.length()) {
      return false;
    }

    var inputArr1 = firstInput.toCharArray();
    var inputArr2 = secondInput.toCharArray();

    for (char character : inputArr1) {
      this.hashtable.put(Character.toLowerCase(character), 1);
    }

    for (char character : inputArr2) {
      boolean result = hashtable.containsKey(Character.toLowerCase(character));
      if (!result) {
        return false;
      }
    }

    return true;
  }
}
