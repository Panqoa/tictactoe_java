import java.util.*;
public class TicTacToe
{
    char a[][]=new char[3][3];
    String name;
    char c;
    char cchar;
    String p1;
    String p2;


    TicTacToe()
    {
        name="";
        for(int i=0;i<=2;i++)
        {
            for(int j=0;j<=2;j++)
            {
                this.a[i][j]=' ';
            }
        }
    }

    public void print()
    {
        int i=0,j=0;
        System.out.println("-----------");

        for(i=0;i<=2;i++)
        {
            for( j=0;j<=2;j++)
            {
                System.out.print("| "+this.a[i][j]);
            }
            System.out.println(" |");
            System.out.println("-----------");
        }

    }

    public boolean EntryCheck(int row,int col)
    {
        if(this.a[row][col]==' ')
            return true;
        else
            return false;
    }

    public void PSpace(int x)
    {
        for(int i=0;i<x;i++)
            System.out.println();
    }

    public void EnterYvsC(int ch)
    {
        Scanner sc=new Scanner(System.in);
        if(ch==1)
        {
            for(int i=0;i<=8;i++)
            {
                this.print();
                System.out.println("Enter row number");
                int row=sc.nextInt();
                row--;
                System.out.println("Enter column number");
                int col=sc.nextInt();
                col--;
                if(this.EntryCheck(row,col))
                {
                    this.a[row][col]=this.c;
                    i++;
                }
                else
                {
                    i--;
                    System.out.println("Already entered here. Cannot enter here now.");
                    this.PSpace(5);
                    continue;
                }

                this.print();
                this.PSpace(5);
                if(this.Check(c,row,col))
                {
                    System.out.println("You Won!");

                    System.exit(0);
                }
                if(i>=8)
                {
                    System.out.print("Match was draw");
                    System.exit(0);
                }
                boolean comp=true;
                int compro=0,compcol=0;
                while(comp)
                {
                    compro=(int)((Math.random())*(2-0+1)+0);
                    compcol=(int)((Math.random())*(2-0+1)+0);
                    if(this.a[compro][compcol]==' ')
                    {
                        this.a[compro][compcol]=this.cchar;
                        comp=false;
                    }}

                if(this.Check(cchar,compro,compcol))
                {
                    this.print();
                    System.out.println("Computer Won! Better Luck Next Time");
                    System.exit(0);
                }

                this.PSpace(5);

            }
            System.out.println("Match was draw");
            System.exit(0);
        }
        else if(ch==2)
        {
            int i=0;
            int ccheck=0;
            for(i=0;i<=8;i++)
            {
                boolean comp=true;

                int compro=0,compcol=0;
                if(ccheck==0)
                {
                    while(comp)
                    {
                        compro=(int)((Math.random())*(2-0+1)+0);
                        compcol=(int)((Math.random())*(2-0+1)+0);
                        if(this.a[compro][compcol]==' ')
                        {
                            this.a[compro][compcol]=this.cchar;
                            comp=false;
                        }}

                    if(this.Check(cchar,compro,compcol))
                    {
                        this.print();
                        System.out.println("Computer Won! Better Luck Next Time");
                        System.exit(0);}}
                else
                    ccheck=0;

                if(i>=8)
                {
                    this.print();
                    System.out.println("Match was Draw");
                    System.exit(0);
                }
                this.PSpace(5);
                this.print();
                System.out.println("Enter row number");
                int row=sc.nextInt();
                row--;
                System.out.println("Enter column number");
                int col=sc.nextInt();
                col--;
                if(this.EntryCheck(row,col))
                {
                    this.a[row][col]=this.c;
                    i++;	
                }
                else
                {
                    i--;
                    ccheck++;
                    System.out.println("Already entered here. Cannot enter here now");
                    this.PSpace(5);
                    continue;
                }
                if(this.Check(c,row,col))
                {
                    this.PSpace(5);
                    this.print();
                    System.out.println("You Won!");

                    System.exit(0);
                }}
            System.out.println("Match is Draw");
            System.exit(0);
        }
        else
            System.out.println("Invalid choice");
    }

    public boolean Check(char cc , int ro , int co)
    {
        boolean res=false;
        int cro=0,cco=0;
        boolean cd=false;
        char x=' ', y=' ',z=' ';
        for(int i=0;i<=2;i++)
        {
            if(this.a[i][co]==cc)
                cro++;
        }
        for(int i=0;i<=2;i++)
        {
            if(this.a[ro][i]==cc)
                cco++;
        }
        if((ro+co)%2==0)
        {
            if(ro==co)
            {
                x=this.a[0][0];
                y=this.a[1][1];
                z=this.a[2][2];
                if(x==y&&y==z)
                    cd=true;
            }
            if(ro+co==2)
            {
                x=this.a[0][2];
                y=this.a[1][1];
                z=this.a[2][0];
                if(x==y && y==z)
                    cd=true;
            }}
        if(cro==3||cco==3||cd==true)
            res=true;
        return res;
    }

    public void Enter1vs2()
    {
        Scanner k=new Scanner(System.in);
        int ccheck=0;
        for(int i=0;i<=8;i++)
        {
            if(ccheck==0)
            {
                this.print();
                System.out.println(this.p1+":");
                System.out.println("Enter row number");
                int rp1= k.nextInt();
                rp1--;
                System.out.println("Enter column number");
                int cp1=k.nextInt();
                cp1--;
                if(this.EntryCheck(rp1,cp1))
                {
                    this.a[rp1][cp1]=this.c;
                    i++;
                }
                else
                {
                    i--;
                    System.out.println("Already entered here.Cannot enter here.");
                    this.PSpace(5);
                    continue;
                }

                this.PSpace(5);
                if(this.Check(c,rp1,cp1))
                {
                    this.print();
                    System.out.println(p1+" won!");
                    System.exit(0);
                }}
            else
                ccheck=0;
            if(i>=8)
            {
                this.print();
                System.out.println("Match was Draw");
                System.exit(0);
            }
            this.print();
            this.PSpace(5);
            System.out.println(p2+":");
            System.out.println("Enter row number");
            int rp2=k.nextInt();
            rp2--;
            System.out.println("Enter column number");
            int cp2=k.nextInt();
            cp2--;
            if(this.EntryCheck(rp2,cp2))
            {
                this.a[rp2][cp2]=this.cchar;
            }
            else
            {
                i--;
                System.out.println("Already entered here. Cannot enter here");
                this.PSpace(5);
                ccheck++;
                continue;
            }
            if(this.Check(cchar,rp2,cp2))
            {
                this.print();
                System.out.println(p2+" won");
                System.exit(0);
            }
        }
        this.PSpace(5);
        this.print();
        System.out.println("Match was Draw");
        System.exit(0);
    }

 		
 		
    public static void main(String args[]) 
    { 
        TicTacToe obj[] = new TicTacToe[10];
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter 1 for New Game");
        System.out.println("Enter 2 for Load Game");    System.out.println("Enter 3 for Exit");
        int fc=sc.nextInt();
        int pn=0;
        if(fc==1)
        {
            for(int i=0; i<=9;i++)
            {
                if(obj[i]==null)
                    obj[i]= new TicTacToe();
                if(obj[i].name=="")
                {
                    pn=i;

                    break;
                }
            }
            System.out.println("Enter name of profile");

            obj[pn].name=sc.next();
            obj[pn].NewGame();
        }
    }

    public void NewGame()
    {
        Scanner ky=new Scanner(System.in);
        System.out.println("Enter mode(as 1 or 2).");
        System.out.println("1.You vs Computer");
        System.out.println("2.Player1 vs Player2");
        int ch= ky.nextInt();
        switch(ch)
        {
            case 1:
                System.out.println("Choose your chararacter (from ×,○,☆)");
                this.c=ky.next().charAt(0);
                System.out.println("Choose computer character among the rest two");
                this.cchar=ky.next().charAt(0);

                System.out.println("Do you want first turn or you want computer to take first turn?  For first turn enter 1, else enter 2");
                ch=ky.nextInt();
                this.EnterYvsC(ch);
                break;
            case 2:
                System.out.println("Enter Player 1's name");
                this.p1=ky.next();
                System.out.println("Enter character for "+p1+" (from ×,○,☆)");
                this.c=ky.next().charAt(0);
                System.out.println("Enter Player 2's name");
                this.p2=ky.next();
                System.out.println("Enter character for "+p2+" from rest two");
                this.cchar=ky.next().charAt(0);
                this.Enter1vs2();
                break;
            default:
                System.out.println("Invalid choice");
        }

			
    }
}
