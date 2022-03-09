package dataBase;

import lombok.Getter;
import lombok.Setter;
import models.HitResult;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.geom.Arc2D;

@Getter
@Setter
@Entity
@Table (name = "RESULTS")
public class HitStorageBD {

    public HitStorageBD(){
    }

    public HitStorageBD(HitResult hitResult){
        this.X = hitResult.getX().floatValue();
        this.Y = hitResult.getY().floatValue();
        this.R = hitResult.getR().floatValue();
        this.RES = hitResult.isHitted() ? "Y" : "N";
    }

    public HitStorageBD(float x, float y, float r, String Res){
        this.X = x;
        this.Y = y;
        this.R = r;
        this.RES = Res;
    }

    private float X;
    private float Y;
    private float R;
    private String RES;

    @Id
    @GeneratedValue(generator = "ID_SEQ")
    @GenericGenerator(
            name = "ID_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence__name", value = "id_seq"),
                    @Parameter(name = "initial__value", value = "1"),
                    @Parameter(name = "increment__size", value = "1")
            }
    )
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "HitStorageBD{" +
                "X=" + X +
                ", Y=" + Y +
                ", R=" + R +
                ", RES='" + RES + '\'' +
                ", id=" + id +
                '}';
    }

    public void setX(float x) {
        X = x;
    }

    public float getX() {
        return X;
    }

    public void setY(float y) {
        Y = y;
    }

    public float getY() {
        return Y;
    }

    public void setR(float r) {
        R = r;
    }

    public float getR() {
        return R;
    }

    public void setRES(String RES) {
        this.RES = RES;
    }

    public String getRES() {
        return RES;
    }

}
