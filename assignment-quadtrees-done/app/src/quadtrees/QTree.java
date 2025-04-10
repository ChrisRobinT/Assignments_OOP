package quadtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class QTree {
	private QuadTreeNode root;

	public QTree(Reader input) {
		root = readQTree(input);
	}

	public QTree(Bitmap bitmap) {
		root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
	}

	public void fillBitmap(Bitmap bitmap) {
		root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
	}

	public void writeQTree(Writer sb) {
		root.writeNode(sb);
	}

	private static QuadTreeNode readQTree(Reader input) {
		try {
			int b = input.read() - '0';
			if (b == 0) {
				int a = input.read() - '0';
				if (a == 0) {
					return new BlackLeaf();
				} else if (a == 1) {
					return new WhiteLeaf();
				}
			} else if (b == 1) {
				QuadTreeNode topLeft = readQTree(input);
				QuadTreeNode topRight = readQTree(input);
				QuadTreeNode bottomRight = readQTree(input);
				QuadTreeNode bottomLeft = readQTree(input);
				return new GreyNode(topLeft, topRight, bottomRight, bottomLeft);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return null;
	}



	public static QuadTreeNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
		for (int n = y; n < width; n++) {
			for (int m = x; m < width; m++) {
				if (bitmap.getBit(m, n) != bitmap.getBit(x, y)) {
					return new GreyNode(bitmap2QTree(x, y, width / 2, bitmap),
							bitmap2QTree(x + width / 2, y, width / 2, bitmap),
							bitmap2QTree(x + width / 2, y + width / 2, width / 2, bitmap),
							bitmap2QTree(x, y + width / 2, width / 2, bitmap));

				}
			}
		}
		if (bitmap.getBit(x, y)) {
			return new WhiteLeaf();
		} else{
			return new BlackLeaf();
		}
	}
}


