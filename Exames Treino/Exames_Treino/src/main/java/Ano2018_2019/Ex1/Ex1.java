package Ano2018_2019.Ex1;

import java.util.LinkedList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        String[] tags1 = {"<body>", "<h1>", "</h1>", "<p>", "<a>", "</a>", "</p>", "</body>"};
        System.out.println(validaTags(tags1));
        System.out.println("===========================================");
        String[] tags2 = {"<body>", "<h1>", "</h1>", "<p>", "<a>", "</p>", "</a>", "</p>", "<body>"};
        System.out.println(validaTags(tags2));
        System.out.println("===========================================");
        String[] tags3 = {"<body>", "<h1>", "</h1>", "<p>", "<a>", "</a>", "</p>"};
        System.out.println(validaTags(tags3));
        System.out.println("===========================================");
        String[] tags4 = {"<body>", "<h1>", "</h1>", "<p>", "<a>", "</a>", "</body>"};
        System.out.println(validaTags(tags4));
        System.out.println("===========================================");
        String[] tags5 = {"<body>", "<h1>", "</h1>", "<a>", "</a>", "</p>", "</body>"};
        System.out.println(validaTags(tags5));
    }

    public static boolean validaTags(String[] tags) {
        List<Boolean> checker = new LinkedList<>();
        String firstTag = tags[0];
        String[] splitter = firstTag.split("<");
        String lastTag = "<" + "/" + splitter[1];
        if (!tags[tags.length - 1].equals(lastTag)) {
            return false;
        }
        for (int i = 0; i < tags.length; i++) {
            if (String.valueOf(tags[i].charAt(1)).equals("/")) {
                checker.add(checkForBar(tags[i], i, tags));
            }
        }
        for (int i = 0; i < tags.length; i++) {
            if (!String.valueOf(tags[i].charAt(1)).equals("/")) {
                checker.add(checkNoBar(tags[i], i, tags));
            }
        }
        return !checker.contains(false);
    }

    static boolean checkForBar(String a, int index, String[] tags) {
        String[] splitter = a.split("/");
        String s = splitter[0] + splitter[1];
        for (int i = 0; i < tags.length; i++) {
            if (tags[i].equals(s) && i < index) {
                return true;
            }
        }
        return false;
    }

    static boolean checkNoBar(String a, int index, String[] tags) {
        String[] splitter = a.split("<");
        String s = "</" + splitter[1];
        for (int i = 0; i < tags.length; i++) {
            if (tags[i].equals(s) && i > index) {
                return true;
            }
        }
        return false;
    }
}
