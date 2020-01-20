package 排序.直接插入排序;





public class Test {
	public static void main(String[] args) {
		Integer[] arrayOld = {57, 68, 59, 52, 99, 43, 21, 43, 65};
		Integer[] arrayNew = new Integer[arrayOld.length];
		for (int i = 0; i < arrayOld.length; i++) {
			if (i == 0) {
				int oldNumber = arrayOld[i];
				if (arrayOld[0] < arrayOld[1]) {
					arrayNew[0] = arrayOld[0];
				} else {
					arrayNew[0] = arrayOld[1];
				}
				
				for (int j = 0; j < arrayNew.length; j++) {
					int newNumber = arrayNew[j];
					if (oldNumber > newNumber) {
						arrayNew[j+1] = oldNumber;
					}
				}
			}
		}
		
		//数组转list
		/*List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
		for (int i = 1; i < list.size(); i++) {
			int curVal = list.get(i);
			List<Integer> beforeList = list.subList(0, i);
			for (int j = 0; j < beforeList.size(); j++) {
				if (i+1 == list.size()) {
					break;	
				}
				int curValIn = beforeList.get(j);
				int lastValIn = beforeList.get(j-1);
				if (i == 1) {
					if (curVal > curValIn) {
						list.set(j, curValIn);
						list.set(j-1, curVal);
					}
					// 如果当前值大于数组的中间某个位置,那们插入
				} else if (curVal > lastValIn && curVal < curValIn) {
//					list.set(j, element)
				}
			}
		}
		// 和前面所有元素相比较,放到合适的位置
		// 1 取得前面所有元素
		for (int i = 0; i < array.length; i++) {
			System.err.println(array[i]);
		}*/
	}
}
