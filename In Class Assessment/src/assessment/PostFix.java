package assessment;
import java.util.Stack;

public class PostFix {
	Stack <Double> symbols;
	String exp;
	
	public PostFix(String s){
		exp = s;
		symbols = new Stack <Double> ();
	}
	
	public String[] splitExpression(String expression){
        String[] list = expression.split(" ");
        return list;
	}
	
	public double solve(){
		String [] list = splitExpression(exp);
		String num = "0123456789";
		String oper = "+-*/";
		int count = 0;
		while (count < list.length){
			String value = list[count];
			if (num.contains(value)){
				symbols.push(Double.parseDouble(value));
			}
			else if (oper.contains(value)){
				Double temp2 = symbols.pop();
				Double temp1 = symbols.pop();
				if (value.equals("+")){
					symbols.push(temp1+temp2);
				}
				else if (value.equals("-")){
					symbols.push(temp1-temp2);
				}
				else if (value.equals("*")){
					symbols.push(temp1*temp2);
				}
				else if (value.equals("/")){
					symbols.push(temp1/temp2);
				}
			}
			count++;
		}
		return symbols.peek();
	}

    public static void main(String[] args){
    	PostFix test = new PostFix("2 7 + 1 2 + +");
        System.out.println(test.exp + " = " +test.solve());
        
        PostFix test2 = new PostFix("1 2 3 4 + + +");
        System.out.println(test2.exp + " = " +test2.solve());
        
        PostFix test3 = new PostFix("9 3 * 8 / 4 + ");
        System.out.println(test3.exp + " = " +test3.solve());
        
        PostFix test4 = new PostFix("3 3 + 7 * 9 2 / +");
        System.out.println(test4.exp + " = " +test4.solve());
        
        PostFix test5 = new PostFix("9 3 / 2 * 7 9 * + 4 -");
        System.out.println(test5.exp + " = " +test5.solve());
        
        PostFix test6 = new PostFix("5 5 + 2 * 4 / 9 +");
        System.out.println(test6.exp + " = " +test6.solve());
    }

}
