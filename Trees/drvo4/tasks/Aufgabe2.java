/*
Schreiben bzw. vervollständigen Sie gekennzeichnete Programmteile wie in den Kommentaren beschrieben.
Verändern Sie aber nicht vorgegebene Methodenköpfe oder andere vorgegebene Programmteile!
Verwenden Sie die gegebenen Testklassen zum Überprüfen Ihrer Lösung. Die Korrektheit dieser Testfälle
ist notwendig, aber nicht hinreichend für eine korrekte Lösung. Es werden damit nur bestimmte
Spezialfälle geprüft. Liefern die Testklassen keinen Fehler, garantiert dies noch nicht die
Korrektheit Ihrer Lösung gemäß der Angabe.
*/

import com.sun.org.apache.regexp.internal.RE;

public class Aufgabe2 {

    /*
    Aufgabe:
        Objekte der Klasse Tree stellen binäre Suchbäume über ganze Zahlen mit Knoten vom Typ Node dar.
        Ergänzen Sie fehlende Teile der Klasse entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 20):
        10 Punkte für 'countFromLevel',
        10 Punkte für 'toStringLeafs'.

        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

    // Just for testing (geht nicht in die Beurteilung ein).
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        System.out.println(tree);
        System.out.println();

        /* Tree Structure:
             5                level 0
            / \
           2  7               level 1
          /  / \
         1  6  8              level 2
        */

        System.out.println(tree.countFromLevel(0)); // 6
        System.out.println(tree.countFromLevel(1)); // 5
        System.out.println(tree.countFromLevel(2)); // 3
        System.out.println(tree.countFromLevel(3)); // 0

        System.out.println();
        System.out.println(tree.toStringLeafs()); // [1,6,8]

        System.out.println();
        // leerer Baum:
        tree = new Tree();
        System.out.println(tree.countFromLevel(0)); // 0
        System.out.println(tree.countFromLevel(2)); // 0
        System.out.println(tree.toStringLeafs()); // []

    }

}

class Node {

    // Ändern Sie diese Variablen nicht. Deklarieren Sie keine weiteren Objekt-/globalen Variablen.
    int elem;
    Node left;
    Node right;

    // Ändern Sie den Konstruktor nicht.
    Node(int elem) {
        this.elem = elem;
    }

    // Ändern Sie diese Methode nicht.
    void add(int elem) {
        if (elem < this.elem) {
            if (left == null) {
                left = new Node(elem);
            } else {
                left.add(elem);
            }
        } else {
            if (right == null) {
                right = new Node(elem);
            } else {
                right.add(elem);
            }
        }
    }

    @Override
    // Ändern Sie diese Methode nicht.
    public String toString() {
        String result = Integer.toString(elem);
        if (left != null) {
            result = left + "," + result;
        }
        if (right != null) {
            result += "," + right;
        }
        return result;

    }

    int countFromLevel(int level) {
        int countL = 0;
        int countR = 0;
        int count = 0;
        if (level == 0) {
            count = 1;
        }
        if (this.left != null) {
            count += this.left.countFromLevel(level - 1);
        }
        if (this.right != null) {
            count += this.right.countFromLevel(level - 1);
        }

        return count;
    }

    public String toStringLeafs() {
        String result = "";
        if (this.left != null) {
            if (this.left.left == null && this.left.right == null) {
                result += this.left + ",";
            } else {
                result += this.left.toStringLeafs();
            }
        }
        if (this.right != null) {
            if (this.right.left == null && this.right.right == null) {
                result += this.right;
            } else {
                result += this.right.toStringLeafs();
            }
        }
        return result;
    }

    // TODO: Definieren Sie hier die rekursiven Hilfsmethoden.


} // Ende der Definition von Node

class Tree {

    // Die Wurzel des Baums. Deklarieren Sie keine weiteren Objekt-/globalen Variablen.
    private Node root;

    // Fügt 'elem' sortiert in den Baum ein.
    // Ändern Sie diese Methode nicht.
    public void add(int elem) {
        if (root == null) {
            root = new Node(elem);
        } else {
            root.add(elem);
        }
    }

    // Liefert die Anzahl der Knoten ab einer bestimmten Tiefe im Baum.
    // Liefert 0, wenn der Baum leer ist.
    // Vorbedingung: level >= 0.
    public int countFromLevel(int level) {
        // TODO: Implementieren Sie die Methode.
        int result = 0;
        if (level >= 0) {
            if (this.root != null) {
                result = this.root.countFromLevel(level);
            }
        }
        return result; //TODO: Diese Zeile löschen.
    }

    // Liefert eine kommagetrennte Liste der Blattknoten
    // in aufsteigender Reihenfolge und mit umschließenden eckigen Klammern.
    // Liefert "[]", wenn der Baum leer ist.
    public String toStringLeafs() {
        // TODO: Implementieren Sie die Methode.
        return this.root == null ? "[]" :(this.root.left == null && this.root.right == null ? "[" + this.root + "]" : "[" + this.root.toStringLeafs() + "]"); //TODO: Diese Zeile löschen.

    }

    // Liefert eine Komma getrennte Liste der Elemente in aufsteigender Reihenfolge
    // mit umschliessenden eckigen Klammern.
    // Ändern Sie diese Methode nicht.
    @Override
    public String toString() {
        if (root == null) {
            return "[]";
        }
        return "[" + root + "]";

    }

}


