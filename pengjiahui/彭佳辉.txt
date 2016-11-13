第一题：

package App;
import java.util.*;
public class Guess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random=new Random();
		int Number=random.nextInt(9);
		Scanner in=new Scanner(System.in);

		System.out.println("----数字猜猜猜----");
		System.out.println("请输入一个0~9的数字");
		int UserNum=in.nextInt();
		
		if(UserNum!=Number){
			if(UserNum>Number){
				System.out.println("你输入的数"+UserNum+"大于所猜的的数字");
			}else{
				System.out.println("你输入的数"+UserNum+"小于所猜的数字");
			}
		}else{
			System.out.println("恭喜你，答对了！");
		}
		
		
	}



结果：

----数字猜猜猜----
请输入一个0~9的数字
5
你输入的数5大于所猜的的数字


第二题：

package App;
import java.util.*;
public class NumberGuess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random();
		int Number=random.nextInt(9);
		Scanner in=new Scanner(System.in);
		
		System.out.println("----数字猜猜猜----");		
		int count=0;
		if(count<6){             //直接用while，用户猜对时会产生冲突
			while(true){   
				System.out.println("请输入一个0~9的数字");
				int UserNum = in.nextInt();
				
				if(UserNum<0 || UserNum>9){
					System.out.println("你输入的数字有误！");
					count++;
					continue;
				}
			
				if(UserNum==Number){      //else if相对if的镶嵌来说，结构更简化
					System.out.println("恭喜你，答对了！");
					break;
				}else{
					if(UserNum>Number){
						System.out.println("你输入的数字"+UserNum+"大于所猜的数字");
						count++;
					}else{
						System.out.println("你输入的数字"+UserNum+"小于所猜的数字");
						count++;
					}
				}
			
			}
		}else{
			System.out.println("很抱歉，机会已用完！");
		}
	}	

} 


结果：

----数字猜猜猜----
请输入一个0~9的数字
55
你输入的数字有误！
请输入一个0~9的数字
2
你输入的数字2大于所猜的数字
请输入一个0~9的数字
1
你输入的数字1大于所猜的数字
请输入一个0~9的数字
0
恭喜你，答对了！
