package mycode.model;

import java.util.Objects;

public class Jwellary {

    private String jwellary_type;
    private  int jwellary_id;
    private String jwellary_name;
    private String jwellary_description;

    public Jwellary(){}
    public Jwellary(String jwellary_type, int jwellary_id, String jwellary_name, String jwellary_description) {
        this.jwellary_type = jwellary_type;
        this.jwellary_id = jwellary_id;
        this.jwellary_name = jwellary_name;
        this.jwellary_description = jwellary_description;
    }

    public String getJwellary_type() {
        return jwellary_type;
    }

    public void setJwellary_type(String jwellary_type) {
        this.jwellary_type = jwellary_type;
    }

    public int getJwellary_id() {
        return jwellary_id;
    }

    public void setJwellary_id(int jwellary_id) {
        this.jwellary_id = jwellary_id;
    }

    public String getJwellary_name() {
        return jwellary_name;
    }

    public void setJwellary_name(String jwellary_name) {
        this.jwellary_name = jwellary_name;
    }

    public String getJwellary_description() {
        return jwellary_description;
    }

    public void setJwellary_description(String jwellary_description) {
        this.jwellary_description = jwellary_description;
    }

    @Override
    public String toString() {
        return "Jwellary{" +
                "jwellary_type='" + jwellary_type + '\'' +
                ", jwellary_id=" + jwellary_id +
                ", jwellary_name='" + jwellary_name + '\'' +
                ", jwellary_description='" + jwellary_description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jwellary)) return false;
        Jwellary jwellary = (Jwellary) o;
        return jwellary_id == jwellary.jwellary_id && jwellary_type.equals(jwellary.jwellary_type) && jwellary_name.equals(jwellary.jwellary_name) && jwellary_description.equals(jwellary.jwellary_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jwellary_type, jwellary_id, jwellary_name, jwellary_description);
    }

    public Jwellary(String prop){
        String[] split = prop.split(",");
        this.jwellary_type=split[0];
        this.jwellary_id=Integer.parseInt(split[1]);
        this.jwellary_name=split[2];
        this.jwellary_description=split[3];
    }
    public String toSave(){
        return jwellary_type+","+jwellary_id+","+jwellary_name+","+jwellary_description;
    }
}
