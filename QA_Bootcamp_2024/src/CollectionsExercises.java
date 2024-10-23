import java.util.*;

public class CollectionsExercises {

    public static void main(String[] args) {

        int[] numbers = {1, 5, 8, 89};
        Shape[] shapes = { new Circle(), new Triangle(), new Rectangle() };

        for (int n : numbers) {
            System.out.println(n);
        }

        for (Shape s: shapes){
            s.draw();
        }

        shapes[0] = new Square();

        Shape[] myShapes = new Shape[10];

        System.out.println("Lungimea array-ului de forme: " + myShapes.length);

        ArrayList<Object> myList = new ArrayList<>();
        myList.add(new Shape());
        myList.add(new Student());

        System.out.println("Lista este goală? " + myList.isEmpty());
        System.out.println("Primul element din listă: " + myList.get(0));

        for (Object s : myList) {
            System.out.println(s);
        }

        Iterator<Object> it = myList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        ArrayList<Shape> myGenericShapes = new ArrayList<>();
        myGenericShapes.add(new Square());
        myGenericShapes.add(new Rectangle());

        for (Shape s : myGenericShapes) {
            s.draw();
        }

        HashSet<String> hs = new HashSet<>();
        hs.add("alex");
        hs.add("alex"); // Duplicatele nu sunt permise
        System.out.println("Dimensiunea setului: " + hs.size());

        HashMap<Integer, String> myHashMap = new HashMap<>();
        myHashMap.put(1, "alex");
        myHashMap.put(1, "andreea"); // Suprascrie valoarea pentru cheia 1
        System.out.println("Valoarea pentru cheia 1: " + myHashMap.get(1));

        for (Integer k : myHashMap.keySet()) {
            System.out.println("Cheia " + k + " are valoarea: " + myHashMap.get(k));
        }

        Queue<String> breadQueue = new PriorityQueue<>();
        breadQueue.add("Alex");
        breadQueue.add("Silvia");
        System.out.println("Coada de așteptare: " + breadQueue);

        String inputText = "Ana are mere si pere si struguri. Toamna e frumos pentru ca nu e inca frig.";
        printCharFrequency(computeMapFromString(inputText, true));
    }

    public static HashMap<Character, Integer> computeMapFromString(String text, boolean caseSensitive) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        String finalText = caseSensitive ? text : text.toLowerCase();  // Corectare: lipsă punct și virgulă
        for (Character s : finalText.toCharArray()) {
            if (charMap.containsKey(s)) {
                charMap.put(s, charMap.get(s) + 1);  // Incrementare corectă
            } else {
                charMap.put(s, 1);
            }
        }
        return charMap;
    }

    public static void printCharFrequency(HashMap<Character, Integer> charMap) {
        for (Character c : charMap.keySet()) {
            System.out.println(c + " : " + charMap.get(c));
        }
    }
}


class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a triangle");
    }
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

class Student {
    @Override
    public String toString() {
        return "This is a student";
    }
}
