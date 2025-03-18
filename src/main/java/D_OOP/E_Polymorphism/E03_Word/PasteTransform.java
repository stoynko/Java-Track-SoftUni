package D_OOP.E_Polymorphism.E03_Word;

public class PasteTransform implements TextTransform {

    private CutTransform cutTransform;

    public PasteTransform(CutTransform cutTransform) {
        this.cutTransform = cutTransform;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex){
        text.replace(startIndex, endIndex, this.cutTransform.getCut().toString());
    }
}