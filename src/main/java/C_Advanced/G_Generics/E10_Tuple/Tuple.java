package C_Advanced.G_Generics.E10_Tuple;

public class Tuple<A, B> {

    private A objectA;
    private B objectB;

    public Tuple(A objectA, B objectB) {
        this.objectA = objectA;
        this.objectB = objectB;
    }

    public A getObjectA() {
        return objectA;
    }

    public void setObjectA(A objectA) {
        this.objectA = objectA;
    }

    public B getObjectB() {
        return objectB;
    }

    public void setObjectB(B objectB) {
        this.objectB = objectB;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", objectA.toString(), objectB.toString());
    }
}
