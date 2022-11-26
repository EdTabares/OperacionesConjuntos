package conjuntos;

import static conjuntos.Conjuntos.isNumeric;

public class ConList {

    private Node head;

    public ConList() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node newNode) {
        this.head = newNode;
    }

    public void define(ConList universal, String conString) {
        this.empty();
        String[] split = conString.split(",");
        for (int i = 0; i < split.length; i++) {
            if (isNumeric(split[i])) {
                int value = Integer.parseInt(split[i]);
                if (!this.exist(value) && universal.exist(value)) {
                    this.insert(value);
                }
            }
        }
    }

    private void empty() {
        head = null;
    }

    public boolean exist(int value) {
        boolean answer = false;
        if (this.getHead() != null) {
            Node q = this.getHead();
            while (q != null) {
                if (q.getElement() == value) {
                    answer = true;
                    q = q.getLink();
                }
            }
        }
        return answer;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (this.getHead() == null) {
            this.setHead(newNode);
        } else {
            Node q = this.getHead();
            while (q.getLink() != null) {
                q = q.getLink();
            }
            q.setLink(newNode);
        }
    }

    public boolean included(ConList BList) {
        boolean answer = true;
        Node q = this.getHead();
        while (q != null) {
            if (!BList.exist(q.getElement())) {
                answer = false;
            }
            q = q.getLink();
        }
        return answer;
    }

    public ConList union(ConList BList) {
        ConList result = new ConList();
        Node q = this.getHead();
        while (q != null) {
            result.insert(q.getElement());
            q = q.getLink();
        }
        q = BList.getHead();
        while (q != null) {
            if (!this.exist(q.getElement())) {
                result.insert(q.getElement());
            }
            q = q.getLink();
        }
        return result;
    }
    
    public String show(){
        String answer = "[";
        if (this.getHead() != null) {
            Node q = this.getHead();
            answer = answer + q.getElement();
            q = q.getLink();
        }
    }

}
