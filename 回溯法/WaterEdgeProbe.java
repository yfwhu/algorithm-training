/**
 * 
 */
package org.feng.demo;

/**
 * 在一个二维数组平面模型中，探测某一点是否有一条可以让水流留到边界的路径 采用递归回溯的方法
 * 
 * @author Administrator 2017年9月8日 下午12:32:29
 */
public class WaterEdgeProbe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] roadModel = { 
				{ 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 6, 4, 0, 0 }, 
				{ 0, 6, 5, 6, 0, 0 }, 
				{ 0, 6, 5, 4, 5, 0 },
				{ 0, 0, 6, 5, 1, 0 }, 
				{ 0, 0, 0, 0, 0, 0 } 
			};
		int x = 2, y = 2;
		boolean res = hasPath2Edge(roadModel, x, y);
		System.out.println(res);
	}

	/**
	 * @param roadModel
	 * @param x
	 * @param y
	 * @return
	 */
	private static boolean hasPath2Edge(int[][] roadModel, int x, int y) {
		// 过滤不正常数据
		if (roadModel == null || x >= roadModel.length || x < 0 || y >= roadModel[0].length || y < 0) {
			return false;
		}
		// 访问标志位，用于探测下一步时候避免重复之前的路径（动态初始化默认是false）
		boolean[][] visited = new boolean[roadModel.length][roadModel[0].length];
		return hasPathCore(roadModel, x, y, visited);
	}

	/**
	 * @param roadModel
	 * @param x
	 * @param y
	 * @param visited
	 * @return
	 */
	private static boolean hasPathCore(int[][] road, int x, int y, boolean[][] visited) {
		// 如果当前探测到边界则范围true
		if (x == 0 || x == road.length - 1 || y == 0 || y == road[0].length - 1) {
			return true;
		}
		// 发现当前节点已经在当前探测路径上则该探测方向不可行，返回false
		if (visited[x][y] == true) {
			return false;
		}
		// 只有执行探测下一步时候，当前位置才需要添加已访问标志
		visited[x][y] = true;
		boolean left = false, up = false, right = false, down = false;
		// 探测左边
		if (road[x][y - 1] <= road[x][y]) {
			left = hasPathCore(road, x, y - 1, visited);
		}
		// 探测上边
		if (road[x - 1][y] <= road[x][y]) {
			up = hasPathCore(road, x - 1, y, visited);
		}
		// 探测右边
		if (road[x][y + 1] <= road[x][y]) {
			right = hasPathCore(road, x, y + 1, visited);
		}
		// 探测下边
		if (road[x + 1][y] <= road[x][y]) {
			down = hasPathCore(road, x + 1, y, visited);
		}
		// 探测完毕 恢复当前未访问状态
		visited[x][y] = false;
		// 只要有一个方向探测到边界成功就表明存在到达边界的路径
		if (left || up || right || down) {
			return true;
		}
		return false;
	}

}
