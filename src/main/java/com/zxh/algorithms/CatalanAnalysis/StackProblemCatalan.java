package com.zxh.algorithms.CatalanAnalysis;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class StackProblemCatalan {
    String _input;
    char []_inputs=new char[100];
    char []_outputs=new char[100];
    int _innum,_outnum,_push_pop_num;
    long []factorial= new long[101];
    int _num;
    boolean []used=new boolean[100];
    boolean []more_once=new boolean[100];
    StackProblemCatalan(){}

    void  calc_factorial(int num)
    {
        int i;
        i=0;
        factorial[0]=1;factorial[1]=1;
        for(i=2;i<=num;i++)
        {
            factorial[i]=factorial[i-1]*i;
        }
    }

    void dfs(int innum,int outnum){
        int i;
        if(outnum==_num){
            for(i=0;i<_num;i++){
                System.out.printf("%c",_outputs[i]);
            }
            System.out.printf("\n");
            _push_pop_num++;
            return;
        }

        if(innum>0){
            _outputs[outnum]=_inputs[innum-1];
            innum--;
            outnum++;
            dfs(innum,outnum);
            innum++;
            outnum--;
            _inputs[innum-1]=_outputs[outnum];
            _outputs[outnum]='\0';
        }
        if(_num - innum - outnum >= 1 ){
            _inputs[innum]=_input.charAt(innum+outnum);
            innum++;
            dfs(innum,outnum);
            innum--;
        }
    }

    public void calc_push_pop() throws IOException
    {
        int i=0;

        System.out.printf("输入字符串:");
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        _input = stdin.readLine();


        _push_pop_num=0;
        _innum=0;
        _outnum=0;

        System.out.println(_input);

        _innum=0;_outnum=0;
        _num=_input.length();

        _outputs[1]='\0';
        _outputs[_num+1]='\0';

        dfs(_innum,_outnum);
    }



}
