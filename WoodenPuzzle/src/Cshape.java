public class Cshape extends Shape {

	public Cshape(int x, int y, Grid g) {
		letter = "C";
		this.grid = g;
		blocks = new Block[2];
		blocks[0] = new Block(x, y, this);
		blocks[1] = new Block(x, y + 1, this);
	}

	public boolean OutOfBounds(int x, int y) {
		if (x < 0 || y < 0 || x >= grid.width || y >= grid.height)
			return false;
		return true;
	}

	@Override
	//THIS NEEDS WORK
	public boolean MoveUp() {
		int x = blocks[0].x;
		int y = blocks[0].y;
		if (OutOfBounds(x, y - 1)
				&& grid.grid[x][y - 1].parent.letter.equals("E")) {
			Eshape tmp = (Eshape) grid.grid[x][y - 1].parent;
			blocks[0].y -= 1;
			blocks[1].y -= 1;
			tmp.blocks[0].y = y + 1;
			grid.grid[x][y - 1] = blocks[0];
			grid.grid[x][y] = blocks[1];
			grid.grid[x][y+1] = tmp.blocks[0];
			return true;
		}
		return false;
	}

	@Override
	
	public boolean MoveDown() {
		int x = blocks[0].x;
		int y = blocks[0].y;
		if (OutOfBounds(x, y + 2)
				&& grid.grid[x][y + 2].parent.letter.equals("E")) {
			Eshape tmp = (Eshape) grid.grid[x][y + 2].parent;
			blocks[0].y += 1;
			blocks[1].y += 1;
			tmp.blocks[0].y = y;
			grid.grid[x][y + 1] = blocks[0];
			grid.grid[x][y + 2] = blocks[1];
			grid.grid[x][y] = tmp.blocks[0];
			return true;
		}
		return false;
	}

	@Override
	public boolean MoveLeft() {
		int x0 = blocks[0].x;
		int y0 = blocks[0].y;
		int x1 = blocks[1].x;
		int y1 = blocks[1].y;
		if (OutOfBounds(x0 - 1, y0)
				&& grid.grid[x0 - 1][y0].parent.letter.equals("E")
				&& grid.grid[x1 - 1][y1].parent.letter.equals("E")) {
			Eshape tmp = (Eshape) grid.grid[x0 - 1][y0].parent;
			Eshape tmp2 = (Eshape) grid.grid[x1 - 1][y1].parent;
			blocks[0].x -= 1;
			blocks[1].x -= 1;
			tmp.blocks[0].x = x0;
			tmp2.blocks[0].x = x1;
			grid.grid[x0 - 1][y0] = blocks[0];
			grid.grid[x1 - 1][y1] = blocks[1];
			grid.grid[x0][y0] = tmp.blocks[0];
			grid.grid[x1][y1] = tmp2.blocks[0];
			return true;
		}
		return false;
	}

	@Override
	public boolean MoveRight() {
		int x0 = blocks[0].x;
		int y0 = blocks[0].y;
		int x1 = blocks[1].x;
		int y1 = blocks[1].y;
		if (OutOfBounds(x0 + 1, y0)
				&& grid.grid[x0 + 1][y0].parent.letter.equals("E")
				&& grid.grid[x1 + 1][y1].parent.letter.equals("E")) {
			Eshape tmp = (Eshape) grid.grid[x0 + 1][y0].parent;
			Eshape tmp2 = (Eshape) grid.grid[x1 + 1][y1].parent;
			blocks[0].x += 1;
			blocks[1].x += 1;
			tmp.blocks[0].x = x0;
			tmp2.blocks[0].x = x1;
			grid.grid[x0 + 1][y0] = blocks[0];
			grid.grid[x1 + 1][y1] = blocks[1];
			grid.grid[x0][y0] = tmp.blocks[0];
			grid.grid[x1][y1] = tmp2.blocks[0];
			return true;
		}
		return false;

	}
}

    
