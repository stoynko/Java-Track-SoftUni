package Y_ExamPreparation.ExamPrep_01.E03_Geoglyphs;

import java.util.*;
import java.util.stream.*;

import static Y_ExamPreparation.ExamPrep_01.E03_Geoglyphs.ConstantMessages.*;


public class Location {

    private String name;
    Collection <Geoglyph> geoglyphs;

    public Location(String name) {
        this.name = name;
        this.geoglyphs = new ArrayList<>();
    }

    public String addGeoglyph(Geoglyph geoglyph) {

        Geoglyph glyph = this.geoglyphs.stream().filter(g -> g.getName().equals(geoglyph.getName())).findFirst().orElse(null);

        if (glyph == null) {
            this.geoglyphs.add(geoglyph);
            return String.format(GEOGLYPH_ADDED, geoglyph.getName(), this.name);
        } else {
            throw new IllegalArgumentException(EXISTING_GEOGLYPH);
        }
    }

    public boolean removeGeoglyph(String name) {
        return this.geoglyphs.removeIf(geoglyph -> geoglyph.getName().equals(name));
    }

    public String getGeoglyphsByConstructionTechnique(String constructionTechnique) {
        List<Geoglyph> foundGeoglyphs = this.geoglyphs.stream()
                                        .filter(geoglyph -> geoglyph.getConstructionTechnique()
                                        .equals(constructionTechnique)).toList();
        if (!foundGeoglyphs.isEmpty()) {
            String output = foundGeoglyphs.stream().map(Geoglyph::getName).collect(Collectors.joining(", "));
            return String.format(GEOGLYPHS_BY_TECHNIQUE, constructionTechnique, output);
        } else {
            return String.format(NO_GEOGLYPHS_BY_TECHNIQUE, constructionTechnique);
        }
    }

    public String getLargestGeoglyph() {
        Geoglyph largestGeoglyph = null;
        int largestSize = 0;

        for (Geoglyph geoglyph : this.geoglyphs) {
            if (geoglyph.getSize() > largestSize) {
                largestSize = geoglyph.getSize();
                largestGeoglyph = geoglyph;
            }
        }
        return String.format(LARGEST_GEOGLYPH, largestGeoglyph.getName(), largestGeoglyph.getSize());
    }

    public Geoglyph getGeoglyphByName(String name) {
        return this.geoglyphs.stream().filter(geoglyph -> geoglyph.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.geoglyphs.size();
    }

    public String getStatistics() {
        if (!this.geoglyphs.isEmpty()) {
            StringBuilder output = new StringBuilder();
            output.append(String.format(GEOGLYPHS_IN_LOCATION, this.name));
            this.geoglyphs.forEach(geoglyph -> {
                output.append(System.lineSeparator());
                output.append("* " + geoglyph.getName());
            });
            return output.toString();
        } else {
            return String.format(NO_GEOGLYPHS_DISCOVERED, this.name);
        }
    }
}
