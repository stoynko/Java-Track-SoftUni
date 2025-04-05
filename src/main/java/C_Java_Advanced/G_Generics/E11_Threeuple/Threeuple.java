package C_Java_Advanced.G_Generics.E11_Threeuple;

public class Threeuple<A, B, C> {

    private A objectA;
    private B objectB;
    private C objectC;

    public Threeuple(A objectA, B objectB, C objectC) {
        this.objectA = objectA;
        this.objectB = objectB;
        this.objectC = objectC;
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

    public C getObjectC() {
        return objectC;
    }

    public void setObjectC(C objectC) {
        this.objectC = objectC;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", objectA.toString(), objectB.toString(), objectC);
    }
}
