import java.util.*;

public class CollectionsExercises {

    public static void main(String[] args) {

        int[] numbers = { 1, 5, 8, 89};
        Shape[] shapes = { new Circle(), new Triangle(), new Rectangle() };

        for (int n : numbers) {
            System.out.println(n);
        }

        for (Shape s: shapes) {
            s.draw();
        }

        shapes[0] = new Square();

        Shape[] myShapes = new Shape[10];
//        myShapes[0].draw();

        System.out.println(myShapes.length);

        ArrayList myList = new ArrayList();
        myList.add(new Shape());
        myList.add(new Student());
        System.out.println(myList.isEmpty());
        myList.get(0);

        for (Object s : myList) {
            System.out.println(s);
        }

        Iterator it = myList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

//        myList.remove(10);

        ArrayList<Shape> myGenericShapes = new ArrayList<Shape>();
        myGenericShapes.add(new Square());
        myGenericShapes.add(new Rectangle());
        for (Shape s : myGenericShapes) {
            s.draw();
        }

        HashSet<String> hs = new HashSet<>();
        hs.add("alex");
        hs.add("maria");
        hs.add("ionela");
        hs.add("mihai");

        System.out.println(hs.size());
        for (String s : hs) {
            System.out.println(s);
        }

        HashMap<Integer, String> myHashMap = new HashMap<>();
        myHashMap.put(1, "alex");
        myHashMap.put(1, "andreea");
//        System.out.println(myHashMap.get(1));

        for(Integer k : myHashMap.keySet()) {
//            System.out.println(myHashMap.get(k));
        }

        Queue<String> breadQueue = new PriorityQueue<>();
        breadQueue.add("Alex");
        breadQueue.add("Silvia");

        System.out.println(Browsers.BRAVE);

        String inputText = "Ana are mere si pere si struguri. Toamna e frumos pentru ca nu e inca frig.";
        printCharFrequency(computeMapFromString(inputText, false));
    }

    public static HashMap<Character, Integer> computeMapFromString(String text, boolean caseSensitive) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        String finalText = caseSensitive ? text : text.toLowerCase();
        for(Character s : finalText.toCharArray()) {
            if (charMap.containsKey(s)) {
//                int currentCount = charMap.get(s);
//                currentCount++;
//                charMap.put(s, currentCount);
                charMap.put(s, charMap.get(s) + 1);
            }
            else {
                charMap.put(s, 1);
            }
        }
        return charMap;
    }

    public static void printCharFrequency(HashMap<Character, Integer> charMap) {
        int sum = 0;
        for (Character c : charMap.keySet()) {
            sum += charMap.get(c);
        }
        for (Character c : charMap.keySet()) {
            System.out.println(c + " : " + charMap.get(c) * 100.0 / sum  );        }
    }


}