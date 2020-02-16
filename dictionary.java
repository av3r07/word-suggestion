import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
public class dictionary
{  
    public static void main(String[] args)   
    {  

        String line = "";  
        String splitBy = ",";  
        int i=0,j=0;
        try   
        {  
            int c=0;
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("dictionary.csv"));  
            while ((line = br.readLine()) != null)   //returns a Boolean value  
            { 
                c++;//counter to count the number of words
            }
            if(c<6)//checks wether there is 6 words in dictionary or not as 6 being the minimum value of words
            {
                System.out.println("minimum 6 words are required");
                System.exit(0);
            }
            String s[]=new String[c];
            int n[]=new int[c];
			//to store words in string array and frequency in an integer array
            while ((line = br.readLine()) != null)   
            {
                String str="";
                for(i=0;i<line.length();i++)
                {
                    if(line.charAt(i)!=',')
                        str=str+line.charAt(i);
                    else
                    {
                        s[j]=str;
                        str="";
                    }
                }
                n[j]=Integer.parseInt(str);
                j++;
            }
            i=0;j=0;
			//to sort the words according to relevance
            for(i=0;i<s.length;i++)
                for(j=0;j<c;j++)
                {
                    int t=n[i];
                    String temp=s[i];
                    if(n[i]<n[j])
                    {
                        n[i]=n[j];
                        n[j]=t;
                        s[i]=s[j];
                        s[j]=temp;
                    }
                }
            System.out.println("enter the word in dictionary");
            String input=br.readLine();
            int n1=input.length();
            int check;
            int f=0;
			//to print the 5 closest words to the word which matches in dictionary
            for(int k=0;k<c;k++)
            {

                if(input==s[k]){
                    check=k;f=1;
                    if((check-2)==0)
                        System.out.println(s[0]+","+s[1]+","+s[3]+","+s[4]+","+s[5]);
                    else if((c-(check+1))==1)
                        System.out.println(s[c-6]+","+s[c-5]+","+s[c-4]+","+s[c-3]+","+s[c-1]);
                    else if((c-(check+1))==0)
                        System.out.println(s[c-6]+","+s[c-5]+","+s[c-4]+","+s[c-3]+","+s[c-2]);
                    else if((check-1)==0)
                        System.out.println(s[0]+","+s[2]+","+s[3]+","+s[4]+","+s[5]);
                    else if((check-1)==0)
                        System.out.println(s[1]+","+s[2]+","+s[3]+","+s[4]+","+s[5]);
                    else 
                        System.out.println(s[k-3]+","+s[k-2]+","+s[k-1]+","+s[k+1]+","+s[k+2]);
                }
                int c1,a,count=0;
                if(f!=1)//to check the correct word for mispelled word
                    
                    for(a=0;a<c;a++)
                    { int x=s[a].length();
                        int y=input.length();
                        if(x==y)
                        {int check1=0;
                            for(int z=0;z<x;z++){

                                if(s[a].charAt(z)==input.charAt(z))
                                    check1++;
                            }
                            if(check1>count)
                            {
                                count=check1;
                                c1=a;
                            }
                        }
                    }
                    if(count!=0)//to print the the correct word for the mispelled word and the 4 closest words
                {
                    {
                        for(int m=0;m<c;m++)
                        {
                            if((k-1)==0)
                                System.out.println(s[1]+","+s[0]+","+s[2]+","+s[3]+","+s[4]);
                            else if((k+2)==c)
                                System.out.println(s[k]+","+s[k-3]+","+s[k-2]+","+s[k-1]+","+s[k+1]);
                            else 
                                System.out.println(s[k]+","+s[k-2]+","+s[k-1]+","+s[k+1]+","+s[k+2]);
                        }

                    }
                }
                else
                    System.out.println("invalid word");
            }
        }
        catch (IOException e)   
        {  
            e.printStackTrace();  
        } 

    }
}