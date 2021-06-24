package day01;

import java.util.Stack;

public class Parsingstringcalculator {

    public static void main(String[] args) {
        Parsingstringcalculator ps = new Parsingstringcalculator();
        String s = "1+15*18";
        System.out.println(ps.calc(s));

    }

    public int calc(String str){
        int ans=0,i=0;
        char[] sc=str.trim().toCharArray();//生成一个char数组，包含string的所有字符
        //栈
        Stack<Integer> st=new Stack();
        while(i<sc.length)
        {
            if(sc[i]==' ') {//从开始起考虑的空格
                i++;continue;
            }
            char tmp=sc[i];
            if(tmp=='*'||tmp=='/'||tmp=='+'||tmp=='-')
            {
                i++;
                while(i<sc.length&&sc[i]==' ')i++;//考虑运算符之后是否有空格
            }
            int num=0;
            //判断是否是数字，是true，否false
            while(i<sc.length&&Character.isDigit(sc[i])) {
                num=num*10+sc[i]-'0';
//                System.out.println(num);
                i++;
            }
//            System.out.println(tmp);
            switch(tmp)
            {
                case '-':
                    num=-num;//注意这一步，不能采用num-=num；
                    break;
                case '*':
                    num=st.pop()*num;
                    break;
                case '/':
                    num=st.pop()/num;
                    break;
                default:
                    break;
            }
            st.push(num);

        }
        while(!st.empty())
            ans+=st.pop();
        return ans;
    }

}
