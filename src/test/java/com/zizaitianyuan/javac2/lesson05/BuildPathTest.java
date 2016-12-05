package com.zizaitianyuan.javac2.lesson05;



// 这里使用的import方式不一样，import static ...

// 可以把其他类的static方法引入到当前类中，然后就可以直接调用这个方法了



/*

 * 这里使用的import方式不一样，import static ...

 * 可以把其他类的static方法引入到当前类中，然后就可以直接调用这个方法了

 * 这样调用：

 * buildPaths(...);

 * 

 */

import static com.zizaitianyuan.javac2.lesson05.BuildPath.buildPaths;



import static org.hamcrest.CoreMatchers.equalTo;



import java.util.Arrays;

import java.util.List;

import java.util.Map;



import org.junit.Assert;

import org.junit.Test;



public class BuildPathTest {



	@Test

	public void testBuildWithEmptyList() {

		Map<String, List<String>> paths = buildPaths(Arrays.asList());

		

		Assert.assertEquals(0, paths.size());

	}

	

	/*

	 *        A

	 *       / \

	 *      B   C

	 *     /     \

	 *    D       F

	 *   /       / \

	 *  E       G   H

	 * 

	 */

	@Test

	public void testBuildFromOneTree() {

		List<Node> nodes = Arrays.asList(

				new Node("A", null),

				new Node("B", "A"),

				new Node("C", "A"),

				new Node("D", "B"),

				new Node("E", "D"),

				new Node("F", "C"),

				new Node("G", "F"),

				new Node("H", "F")

				);

		Map<String, List<String>>allPaths = buildPaths(nodes);

		

		Assert.assertThat(Arrays.asList("A"), equalTo(allPaths.get("A")));

		

		Assert.assertThat(Arrays.asList("A", "B"), equalTo(allPaths.get("B")));

		Assert.assertThat(Arrays.asList("A", "B", "D"), equalTo(allPaths.get("D")));

		Assert.assertThat(Arrays.asList("A", "B", "D", "E"), equalTo(allPaths.get("E")));

		

		Assert.assertThat(Arrays.asList("A", "C", "F"), equalTo(allPaths.get("F")));

		Assert.assertThat(Arrays.asList("A", "C", "F", "G"), equalTo(allPaths.get("G")));

		Assert.assertThat(Arrays.asList("A", "C", "F", "H"), equalTo(allPaths.get("H")));

		

	}

	

	// 其实还有一些异常的情况，如果存在环怎么处理，这个等到以后再说

}