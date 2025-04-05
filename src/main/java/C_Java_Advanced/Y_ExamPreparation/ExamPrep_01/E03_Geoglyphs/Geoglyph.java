package C_Java_Advanced.Y_ExamPreparation.ExamPrep_01.E03_Geoglyphs;

public class Geoglyph {

    private String name;
    private String shape;
    private int size;
    private String constructionTechnique;

    public Geoglyph(String name, String shape, int size, String constructionTechnique) {
        this.name = name;
        this.shape = shape;
        this.size = size;
        this.constructionTechnique = constructionTechnique;
    }

    @Override
    public String toString() {
        return String.format("%s is %d meters long and is made by %s.", this.name, this.size, this.constructionTechnique);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setConstructionTechnique(String constructionTechnique) {
        this.constructionTechnique = constructionTechnique;
    }

    public String getName() {
        return name;
    }

    public String getShape() {
        return shape;
    }

    public int getSize() {
        return size;
    }

    public String getConstructionTechnique() {
        return constructionTechnique;
    }
}
