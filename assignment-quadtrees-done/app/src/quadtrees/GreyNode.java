package quadtrees;

import java.io.IOException;
import java.io.Writer;

public class GreyNode implements QuadTreeNode{
    private final QuadTreeNode child1, child2, child3, child4;

    public GreyNode(QuadTreeNode child1, QuadTreeNode child2, QuadTreeNode child3, QuadTreeNode child4) {
        this.child1 = child1;
        this.child2 = child2;
        this.child3 = child3;
        this.child4 = child4;
    }

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        child1.fillBitmap(x, y, width/2, bitmap);
        child2.fillBitmap(x + width/2, y, width/2, bitmap);
        child3.fillBitmap(x + width/2, y + width/2, width/2, bitmap);
        child4.fillBitmap(x, y + width/2, width/2, bitmap);
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.write("1");
            child1.writeNode(out);
            child2.writeNode(out);
            child3.writeNode(out);
            child4.writeNode(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
