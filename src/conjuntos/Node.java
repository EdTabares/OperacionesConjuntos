
package conjuntos;


public class Node {
    protected int element;
    protected Node link;
    

    public Node (int element){
        this.element = element;
        link = null;
    }
    
    public int getElement(){
        return element;
    }
    
    public void setElement(int element){
        this.element = element;
    }
    
    public Node getLink(){
        return link;
    }
    
    public void setLink(Node link){
        this.link = link;
    }
    

}
