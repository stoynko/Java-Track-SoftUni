package D_Java_OOP.E_Polymorphism.E03_Word;

public class CutTransform implements TextTransform {

    StringBuilder cut = new StringBuilder();

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        cut = new StringBuilder();
        cut.append(text, startIndex, endIndex);
        text.delete(startIndex, endIndex);
    }

    public StringBuilder getCut() {
        return this.cut;
    }
}
