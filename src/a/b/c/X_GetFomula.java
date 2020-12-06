package a.b.c;

import java.util.Stack;

public class X_GetFomula {
   // private String Formula;
    Stack<Long>formula;
    Stack<Character>OPERATOR;


    public Long calc(String numStr)
    {
        numStr=removeSpaceStr(numStr);

        if(numStr.length()>1&&!"=".equals(numStr.charAt(numStr.length()-1)+""))
        {
            numStr+="=";
        }
        if(!isStandard(numStr))
        {
            System.err.println("错误：表达式有误");
            return (long)0;
        }

        formula=new Stack<>();
        OPERATOR=new Stack<>();
        StringBuffer strBuf=new StringBuffer();

        for(int i=0;i<numStr.length();i++)
        {
            char c=numStr.charAt(i);
            if(isNumber(c))
            {
                strBuf.append(c);
            }
            else{
                String tempStr=strBuf.toString();
                if(!tempStr.isEmpty())
                {
                    Long num=Long.parseLong(tempStr);
                    formula.push(num);
                    strBuf=new StringBuffer();
                }

                while(!standardCheck(c) && !OPERATOR.empty())
                {
                    Long b=formula.pop();
                    Long a=formula.pop();
                    char ss=OPERATOR.pop();
                    switch (ss)
                    {
                        case '+':
                            formula.push(a+b);
                            break;
                        case '-':
                            formula.push(a-b);
                            break;
                        case '*':
                            formula.push(a*b);
                            break;
                        case '/':
                            formula.push(a/b);
                        default:
                            break;
                    }
                }
                if(c!='=')
                {
                    OPERATOR.push(c);
                    if(c==')'){
                        OPERATOR.pop();
                        OPERATOR.pop();
                    }
                }
            }
        }
        return formula.pop();
    }

    private String removeSpaceStr(String str)
    {
        return str!=null?str.replaceAll(" ",""):"";
    }

    private boolean isStandard(String numStr)
    {
        if(numStr==null||numStr.isEmpty())
        return false;
        Stack<Character>stack=new Stack<>();
        boolean b=false;
        for(int i=0;i<numStr.length();i++)
        {
            char n=numStr.charAt(i);
            if(!(isNumber(n)||"+".equals(n+"")||"-".equals(n+"")
                    ||"*".equals(n+"")||"/".equals(n+"")||"(".equals(n+"")||"=".equals(n+"")||")".equals(n+"")))
            {
                return false;
            }

            if("(".equals(n+""))
            {
                stack.push(n);
            }
            if(")".equals(n+""))
            {
                if(stack.empty()||!"(".equals(stack.pop()+""))
                    return false;
            }

            if("=".equals(n+""))
            {
                if(b==true)
                    return false;
                b=true;
            }

        }

        if(!stack.empty())
        {
            return false;
        }
        if(!"=".equals(numStr.charAt(numStr.length()-1)+""))
            return false;
        return  true;
    }

    private boolean isNumber(char c)
    {
        if(c>='0'&&c<='9')
            return true;
        return false;
    }

    private boolean standardCheck(char c)
    {
        if(OPERATOR.empty())
            return true;
        char top=OPERATOR.peek();
        if(top=='(') return true;

        switch (c)
        {
            case '(':
                return true;
            case '*':
                if(top=='+'||top=='-')
                    return true;
                return false;
            case '/':
                if(top=='+'||top=='-')
                    return true;
                return false;
            case '+':
                return false;
            case '-':
                return false;
            case ')':
                return false;
            case '=':
                return false;
            default:
                break;
        }
        return true;
    }
}
