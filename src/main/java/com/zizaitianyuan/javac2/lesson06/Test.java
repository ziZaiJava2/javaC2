package com.zizaitianyuan.javac2.lesson06;

public class Test {
//	创建一个学生的类（Student），要求：
//	有一个构造函数，接受名字（String）作为参数
//	对象有个getName()的方法，可以取得学生的名字。
	
//	创建开一个课程的类(CourseSession),要求：
//
//	有一个构造函数，接受课程编号(String)，和课程名称(String)，作为名字。
//	提供一个getDepartment()的方法来获取课程名称。
//	提供一个getNumber()的方法来获取课程编号
//	测试一下自己的代码，你可以通过main方法来做。保证case通过
//
//	生成一个学生实例，他的名字叫做Leon，可以通过getName()获取这个名字
//	生成一门课程的实例，课程名称是English,编号是102，可以通过对应方法获取课程名称和编号
//	如果你想更进一步，创建两个Test的类，添加单元测试
//
//	添加一个测试方法测试学生，创建一个学生实例，名字叫做Leon,然后assert他的getName()方法返回的名字是Leon。类似于这样。
//
//	public class StudentTest {
//
//	@Test
//	public void testCreateStudent() {
//	    Student leon = new Student("Leon");
//	    Assert.assertEquals("Leon", leon.getName());
//	}
//	}
//	添加一个测试方法测试课程，创建一个English，编号102的课程实例，然后assert他的getter方法返回的值是否正确。参看上面的例子。
//	给课程添加新方法
//
//	添加一个新方法getNumberOfStudents()，返回学习这门课程学生的数量。
//	添加一个新方法enroll(Student student),用来给这门课注册学生。
//	测试一下，保证case通过
//
//	新的测试case，创建一个English的课程，assert默认getNumberOfStudents()返回值为0
//	新的测试case，创建一个English的课程，给这门课程使用enroll(student)方法注册两名学生，assert方法getNumberOfStudents()返回2.
//	给课程添加新方法
//
//	添加方法getAllStudents(),方法的返回值是List<Student>.返回包含所有通过enroll()方法注册的学生的List。
//	新的测试case，创建一个English的课程，给这门课程使用enroll(student)方法注册两名学生，然后通过getAllStudents()取得所有学生，assert返回的学生的对象就是你注册的两个。
//	给课程添加新方法
//
//	添加新方法get(int index), 返回第index个注册的学生。
//	新的测试case，创建一个English的课程，给这门课程使用enroll(student)方法注册3名学生，通过get(2)获取学生，assert和你enroll的第三个学生是不是同一个。
//	删除方法getAllStudents(),这个方法已经不需要了，我们通过删除这个方法，避免暴露我们的实现细节。同时case也可以删除了。
//	重载课程的构造函数
//
//	准备工作，自行学习java.util.Date和java.util.Calendar这两个类。学会怎么使用这两个类，以及通过Calendar来计算一个日期6个月之后是什么日期了。
//
//	添加一个新的构造函数，这次接受三个参数，课程名称，课程编号，开课日期。这里日期使用Date类型。
//	原来的构造函数会转过来调用这个新的构造函数，开课日期是当前日期下个月的第一天。
//	添加方法getStartDate()，返回Date类型，为开课日期
//	添加方法getEndDate()，返回Date类型，为开课日期六个月之后的日期。
//	添加测试方法，需要测试的几个点是：
//	使用两个参数的构造函数生成的课程对象，开始日期getStartDate()是当前月的下一个月的第一天
//	使用三个参数的构造函数生成的课程对象，开始日期getStartDate()是传入的日期，结束日期getEndDate()是传入日期六个月之后
//	给每个public方法添加文档，说明方法是干嘛的。使用下面的这种风格的注释
//
//	/**
//	 *
//	 */
//	添加新类RosterReporter
//
//	添加新的类，这个类是用来生成一门课程的报告的。
//	这个新的类有一个构造函数，接受CourseSession对象。
//	这个新的类有一个方法getReport()，返回一个字符串。字符串是对于构造函数传入的课程的描述:
//	字符串第一行，课程名称，编号，参加学习学生总数，开课日期 ~ 结束日期
//	接着每一行列出一个学生的名字
//	构造一个课程，注册4名学生，然后通过这个新的类打印一个报告出来。
//	创建一个工具类
//
//	什么叫做工具类，工具类就是只有静态方法。类似于Math这个类。同时他的默认构造函数被我们显示的设置为private了，这样在这个类外面就没有办法实例化他了。
//
//	试着创建一个工具类DateUtil
//	给他定义一个无参的构造函数，将修饰符设置为private，然后试试看是否还能创建他的实例。
//	添加一个createDate(int year, int month, int day)的方法，用来创建一个Date，是year年，month月，day日，零时零分零秒。
//	继续修改课程类
//
//	添加一个静态字段count来统计总共有的课程数。
//	添加一个case，创建三个课程对象，然后assert看看CurseSession.count是否等于3
//	定义一个静态方法getCount(),来获取总的课程数。
//	添加一个case，创建三个课程对象，然后assert看看CurseSession.getCount()是否等于3
//	这个时候将静态字段count设置为private，同时删除报错的case。
//	添加工厂方法
//
//	这之前请自己google一下什么是工厂方法
//
//	在CourseSession中创建两个static的create方法，分别接受两个，三个参数，用来生成CourseSession对象。
//	讲CourseSession的构造函数改为private的。
//	然后用create方法替换case中的new语句
//	回到Student这个类
//
//	学生分为全日制和非全制日的。学生修满12个学分就是全日制的学生，否则就是非全日制的
//
//	添加一个新的方法isFullTime()到Student类，该方法返回一个布尔值，用来判断学生是否是全日制的学生。现在先给他返回默认值false。
//	添加一个case，生成一个学生对象，调用他的isFullTime()方法，assert应该返回false（因为新创建的学生还没有修学分）
//	因为修满12个学分的学生才能算全日制学生。
//
//	我们添加一个getCredits()方法，获取学生的学分，返回一个int类型
//	添加一个case，生成一个学生对象，因为还没有修课程，assert他的getCredits()方法的返回值是0
//	添加一个方法addCredits(int credits),用来给学生添加学分
//	添加一个case，想想怎么测试这个新方法。
//
//	好了，现在已经有学分了，可以回过头来实现isFullTime()
//
//	添加一个case，给学生添加12个学分，然后assert他的isFullTime()方法返回true
//	添加一个case，给学生添加11个学分，然后assert他的isFullTime()方法返回false
//	自己再想想，还有什么其他case可以添加吗？比如...
//	更多关于学生的内容
//
//	学生还分为上海本地学生，和外地学生。
//
//	添加新方法isLocal(), 我们说过is开头的方法返回值是什么类型的？
//	给学生添加static字段Student.Local,值设为SH
//	添加新方法SetLocation(String Province),用来设置学生的籍贯
//	添加case，创建一个学生，没有设置籍贯，assert他的isLocal方法返回false
//	添加case，创建一个学生，设置籍贯为Student.Local，assert他的isLocal方法返回true
//	想想还有没有什么其他case
//	新的报告类
//
//	这次我们要创建一个新的报表类，他收集课程，然后可以按课程名称排序
//
//	创建CourseReport类，有add(CourseSession course)方法，可以添加课程到report对象。
//	添加text()方法到CourseReport类，返回字符串，每行名字加编号，按照课程的名字升序排列
//	想想我们在CourseReport中用什么数据结构来保存add进来的课程对象
//	这次我们不在自己写排序算法了，使用Collections.sort()方法来排序
//	自学Collections.sort和Comparable接口，然后使用他们来讲课程排序
//	自己考虑添加一些什么case来测试text()方法
//	好了，我们要给学生添加成绩了
}
