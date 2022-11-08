package conjuntos;

import static conjuntos.Conjuntos.isNumeric;

public class ConVector {

    protected int size; //Numero de elementos
    protected int[] vec; //Definición de vector

    public ConVector() {

    }

    public ConVector(int n) {
        this.size = n;
        this.vec = new int[size];
    }

    public int getDato(int pos) {
        return vec[pos];
    }

    public void setDato(int dato, int pos) {
        vec[pos] = dato;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int a) {
        size = a;
    }

    public int[] getVec() {
        return vec;
    }

    public void setVec(int[] newVec) {
        vec = newVec;
    }

    public void empty() {
        size = 0;
        vec = new int[0];
    }

    public boolean exist(int value) {
        boolean answer = false;
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getDato(i) == value) 
                answer = true;            
        }
        return answer;
    }

    public void insert(int value) {
        int[] newVector = new int[this.size + 1];
        for (int i = 0; i < this.getSize(); i++) {
            newVector[i] = this.getDato(i);
        }
        newVector[this.getSize()] = value;
        this.setVec(newVector);
        this.setSize(this.getSize()+1);
    }

    public void defineU(String setString) {
        this.empty();
        String[] split = setString.split(",");
        for (int i = 0; i < split.length; i++) {
            if (isNumeric(split[i])) {
                int value = Integer.parseInt(split[i]);
                if (!this.exist(value)) { //Revisar acá. Si el valor ya existe no lo repite 
                    this.insert(value);
                }
            }
        }
    }
    
    public void define(ConVector universal, String setString){
        this.empty();
        String[] split = setString.split(",");
        for (int i = 0; i < split.length; i++) {
            if (isNumeric(split[i])){
                int value = Integer.parseInt(split[i]);
                if (!this.exist(value) && universal.exist(value)) {
                    this.insert(value);
                }
            }
        }
    }

    public String show() {
        String answer = "{";
        for (int i = 0; i < this.getSize(); i++) {
            answer = answer + this.getDato(i);
            if (i + 1 != this.getSize())
                answer = answer + ", ";            
        }
        answer = answer + "}";
        return answer;
    }

}
