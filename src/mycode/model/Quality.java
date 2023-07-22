package mycode.model;

import java.util.Objects;

public class Quality {
    private String quality_type;
    private int quality_id;
    private int quality_product_id;
    private String quality_category;
    private String quality_description;

    public Quality(){}

    public Quality(String quality_type, int quality_id, int quality_product_id, String quality_category, String quality_description) {
        this.quality_type = quality_type;
        this.quality_id = quality_id;
        this.quality_product_id = quality_product_id;
        this.quality_category = quality_category;
        this.quality_description = quality_description;
    }

    public Quality(String prop) {
        String[] split=prop.split(",");
        this.quality_type = split[0];
        this.quality_id =Integer.parseInt(split[1]);
        this.quality_product_id = Integer.parseInt(split[2]);
        this.quality_category = split[3];
        this.quality_description = split[4];
    }

    public String getQuality_type() {
        return quality_type;
    }

    public void setQuality_type(String quality_type) {
        this.quality_type = quality_type;
    }

    public int getQuality_id() {
        return quality_id;
    }

    public void setQuality_id(int quality_id) {
        this.quality_id = quality_id;
    }

    public int getQuality_product_id() {
        return quality_product_id;
    }

    public void setQuality_product_id(int quality_product_id) {
        this.quality_product_id = quality_product_id;
    }

    public String getQuality_category() {
        return quality_category;
    }

    public void setQuality_category(String quality_category) {
        this.quality_category = quality_category;
    }

    public String getQuality_description() {
        return quality_description;
    }

    public void setQuality_description(String quality_description) {
        this.quality_description = quality_description;
    }

    @Override
    public String toString() {
        return "Quality{" +
                "quality_type='" + quality_type + '\'' +
                ", quality_id=" + quality_id +
                ", quality_product_id=" + quality_product_id +
                ", quality_category='" + quality_category + '\'' +
                ", quality_description='" + quality_description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quality)) return false;
        Quality quality = (Quality) o;
        return quality_id == quality.quality_id && quality_product_id == quality.quality_product_id && quality_type.equals(quality.quality_type) && quality_category.equals(quality.quality_category) && quality_description.equals(quality.quality_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quality_type, quality_id, quality_product_id, quality_category, quality_description);
    }

    public String toSave(){
        return quality_type+","+quality_id+","+quality_product_id+","+quality_category+","+quality_description;
    }
}
